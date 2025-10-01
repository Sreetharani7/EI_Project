package com.ei.astronautschedule.observer;

import com.ei.astronautschedule.model.Task;

public interface Observer {
    void notifyConflict(Task newTask, Task conflictingTask);
}
