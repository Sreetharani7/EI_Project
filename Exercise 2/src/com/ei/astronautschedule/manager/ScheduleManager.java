package com.ei.astronautschedule.manager;

import java.util.*;
import java.util.logging.Logger;

import com.ei.astronautschedule.model.Task;
import com.ei.astronautschedule.observer.Observer;
import com.ei.astronautschedule.util.TimeValidator;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<Observer> observers;
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) { observers.add(observer); }

    public boolean addTask(Task task) {
        for (Task existing : tasks) {
            if (TimeValidator.isOverlapping(task, existing)) {
                notifyObservers(task, existing);
                return false;
            }
        }
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        logger.info("Task added: " + task);
        return true;
    }

    public boolean removeTask(String description) {
        Optional<Task> taskOpt = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();
        if (taskOpt.isPresent()) {
            tasks.remove(taskOpt.get());
            logger.info("Task removed: " + description);
            return true;
        }
        return false;
    }
    // Edit an existing task
public boolean editTask(String oldDescription, Task newTask) {
    Optional<Task> taskOpt = tasks.stream()
            .filter(t -> t.getDescription().equalsIgnoreCase(oldDescription))
            .findFirst();

    if (taskOpt.isPresent()) {
        Task oldTask = taskOpt.get();

        // Check conflicts with other tasks except the one being edited
        for (Task t : tasks) {
            if (!t.equals(oldTask) && TimeValidator.isOverlapping(newTask, t)) {
                notifyObservers(newTask, t);
                return false;
            }
        }

        tasks.remove(oldTask);
        tasks.add(newTask);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        logger.info("Task edited: " + oldDescription + " -> " + newTask);
        return true;
    }
    return false;
}

// Mark a task as completed
public boolean markTaskCompleted(String description) {
    Optional<Task> taskOpt = tasks.stream()
            .filter(t -> t.getDescription().equalsIgnoreCase(description))
            .findFirst();
    if (taskOpt.isPresent()) {
        taskOpt.get().markCompleted();
        logger.info("Task marked completed: " + description);
        return true;
    }
    return false;
}


    public List<Task> viewTasks() {
        return tasks;
    }

    private void notifyObservers(Task newTask, Task conflict) {
        for (Observer obs : observers) {
            obs.notifyConflict(newTask, conflict);
        }
    }
}

