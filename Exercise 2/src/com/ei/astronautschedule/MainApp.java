package com.ei.astronautschedule;

import com.ei.astronautschedule.factory.TaskFactory;
import com.ei.astronautschedule.manager.ScheduleManager;
import com.ei.astronautschedule.model.*;
import com.ei.astronautschedule.observer.ConflictObserver;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConflictObserver());

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Astronaut Daily Schedule =====");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Mark Task Completed");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter description: ");
                        String desc = sc.nextLine();
                        System.out.print("Enter start time (HH:mm): ");
                        String start = sc.nextLine();
                        System.out.print("Enter end time (HH:mm): ");
                        String end = sc.nextLine();
                        System.out.print("Enter priority (HIGH/MEDIUM/LOW): ");
                        String priority = sc.nextLine().toUpperCase();

                        Task task = TaskFactory.createTask(desc, start, end, PriorityLevel.valueOf(priority));
                        if (manager.addTask(task)) {
                            System.out.println("Task added successfully. No conflicts.");
                        }
                        break;

                    case "2":
                        System.out.print("Enter description of task to remove: ");
                        String remove = sc.nextLine();
                        if (manager.removeTask(remove)) {
                            System.out.println("Task removed successfully.");
                        } else {
                            System.out.println("Error: Task not found.");
                        }
                        break;

                    case "3":
                        if (manager.viewTasks().isEmpty()) {
                            System.out.println("No tasks scheduled for the day.");
                        } else {
                            manager.viewTasks().forEach(System.out::println);
                        }
                        break;

                    case "6":
                        System.out.println("Goodbye astronaut!");
                        sc.close();
                        return;

                    case "4": // Edit Task
                        System.out.print("Enter description of task to edit: ");
                        String oldDesc = sc.nextLine();

                        System.out.print("Enter new description: ");
                        String newDesc = sc.nextLine();
                        System.out.print("Enter new start time (HH:mm): ");
                        String newStart = sc.nextLine();
                        System.out.print("Enter new end time (HH:mm): ");
                        String newEnd = sc.nextLine();
                        System.out.print("Enter new priority (HIGH/MEDIUM/LOW): ");
                        String newPriority = sc.nextLine().toUpperCase();

                        Task editedTask = TaskFactory.createTask(newDesc, newStart, newEnd, PriorityLevel.valueOf(newPriority));
                        if (manager.editTask(oldDesc, editedTask)) {
                            System.out.println("Task edited successfully.");
                        }
                        break;

                        case "5": // Mark Task Completed
                            System.out.print("Enter description of task to mark completed: ");
                            String descToComplete = sc.nextLine();
                            if (manager.markTaskCompleted(descToComplete)) {
                                System.out.println("Task marked as completed.");
                            } else {
                                System.out.println("Error: Task not found.");
                            }
                            break;


                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
