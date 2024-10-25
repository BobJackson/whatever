package com.wangyousong.practice.whatever.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;


    @Test
    void should_given_method_name_when_then_run() {
        String result = greetingService.greet("Bob");
        
        assertNotNull(result);
        assertEquals("Hello Bob", result);
    }
}