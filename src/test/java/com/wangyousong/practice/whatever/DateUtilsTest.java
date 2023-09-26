package com.wangyousong.practice.whatever;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateUtilsTest {

    @Test
    void should_transform_12_to_24_hour() {
        String time = "06:00 PM";
        String localTime = DateUtils.transform12To24Hour(time);

        assertEquals("18:00", localTime);
    }

}
