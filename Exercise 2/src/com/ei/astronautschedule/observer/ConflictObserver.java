package com.ei.astronautschedule.observer;

import com.ei.astronautschedule.model.Task;

public class ConflictObserver implements Observer {
    @Override
    public void notifyConflict(Task newTask, Task conflictingTask) {
        System.out.printf("⚠️ Conflict: '%s' overlaps with existing task '%s'%n",
                newTask.getDescription(), conflictingTask.getDescription());
    }
}
