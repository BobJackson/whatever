package com.wangyousong.practice.whatever.util;

import org.junit.jupiter.api.RepeatedTest;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class RandomTimeGeneratorTest {


    @RepeatedTest(1000)
    void should_generate_random_time() {
        String time = RandomTimeGenerator.generateRandomTime();
        LocalTime localTime = LocalTime.parse(time);

        assertThat(localTime).isBefore(LocalTime.of(23, 0, 0))
                .isAfter(LocalTime.of(10, 0, 0));
    }
}