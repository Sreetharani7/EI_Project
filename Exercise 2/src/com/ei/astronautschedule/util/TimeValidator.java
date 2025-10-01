package com.ei.astronautschedule.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.ei.astronautschedule.model.Task;

public class TimeValidator {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static boolean isValidTimeFormat(String time) {
        try {
            LocalTime.parse(time, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isStartBeforeEnd(String start, String end) {
        return LocalTime.parse(start, FORMATTER).isBefore(LocalTime.parse(end, FORMATTER));
    }

    public static boolean isOverlapping(Task t1, Task t2) {
        LocalTime start1 = LocalTime.parse(t1.getStartTime(), FORMATTER);
        LocalTime end1 = LocalTime.parse(t1.getEndTime(), FORMATTER);
        LocalTime start2 = LocalTime.parse(t2.getStartTime(), FORMATTER);
        LocalTime end2 = LocalTime.parse(t2.getEndTime(), FORMATTER);

        return (start1.isBefore(end2) && end1.isAfter(start2));
    }
}
