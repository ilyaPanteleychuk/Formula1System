package ua.foxminded.ilyapanteleychuk.task6.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateUtil {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    public static LocalDateTime timeFormatterByPattern(String time){
        return LocalDateTime.parse(time, FORMATTER);
    }
}
