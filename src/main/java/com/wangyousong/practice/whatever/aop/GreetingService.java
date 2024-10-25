package com.wangyousong.practice.whatever.aop;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GreetingService {

    private final Random random = new Random();

    public String greet(String name) {
        boolean raiseException = random.nextBoolean();
        if (raiseException) {
            throw new IllegalArgumentException("Oops, something went wrong");
        }
        return "Hello " + name;
    }
}
