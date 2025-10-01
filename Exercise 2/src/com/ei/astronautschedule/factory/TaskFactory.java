package com.ei.astronautschedule.factory;

import com.ei.astronautschedule.model.*;

import com.ei.astronautschedule.util.TimeValidator;

public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, PriorityLevel priority) 
            throws IllegalArgumentException {
        if (!TimeValidator.isValidTimeFormat(startTime) || !TimeValidator.isValidTimeFormat(endTime)) {
            throw new IllegalArgumentException("Error: Invalid time format.");
        }
        if (!TimeValidator.isStartBeforeEnd(startTime, endTime)) {
            throw new IllegalArgumentException("Error: Start time must be before end time.");
        }
        return new Task(description, startTime, endTime, priority);
    }
}
