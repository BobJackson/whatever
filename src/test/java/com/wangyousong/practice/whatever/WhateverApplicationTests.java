package com.wangyousong.practice.whatever;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WhateverApplicationTests {

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
        System.out.println(port);
        assert(port > 0);
    }

}
