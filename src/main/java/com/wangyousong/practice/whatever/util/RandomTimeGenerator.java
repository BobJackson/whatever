package com.wangyousong.practice.whatever.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomUtils;

@UtilityClass
public class RandomTimeGenerator {

    public static String generateRandomTime() {
        RandomUtils utils = RandomUtils.secure();
        int hour = utils.randomInt(10, 23);
        int minute = utils.randomInt(0, 60);
        int second = utils.randomInt(0, 60);
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
