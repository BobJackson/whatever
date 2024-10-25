package com.wangyousong.practice.whatever.multiple.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Qualifier("goodServiceB")
public class GoodServiceB implements GoodService {
    @Override
    public void doSomething() {
        log.info("GoodServiceB do something.");
    }
}
