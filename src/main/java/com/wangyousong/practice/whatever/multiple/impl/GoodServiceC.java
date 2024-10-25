package com.wangyousong.practice.whatever.multiple.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Qualifier("goodServiceC")
public class GoodServiceC implements GoodService {
    @Override
    public void doSomething() {
        log.info("GoodServiceC do something");
    }
}
