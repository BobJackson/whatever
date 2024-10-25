package com.wangyousong.practice.whatever.multiple.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Qualifier("goodServiceA")
public class GoodServiceA implements GoodService {
    @Override
    public void doSomething() {
        log.info("GoodServiceA doSomething");
    }
}
