package com.ei.astronautschedule.model;

public class Task {
    private String description;
    private String startTime;
    private String endTime;
    private PriorityLevel priority;
    private boolean completed;

    public Task(String description, String startTime, String endTime, PriorityLevel priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = false;
    }

    public String getDescription() { return description; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public PriorityLevel getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public void markCompleted() { this.completed = true; }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s] %s",
                startTime, endTime, description, priority,
                completed ? "(Completed)" : "");
    }
}
