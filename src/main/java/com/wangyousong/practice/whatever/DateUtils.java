package com.wangyousong.practice.whatever;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private DateUtils() {
    }

    public static String transform12To24Hour(String time) {
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm a"))
                .format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
