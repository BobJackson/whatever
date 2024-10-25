package com.wangyousong.practice.whatever.multiple.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleQualifierController {
    private final GoodService goodServiceA;
    private final GoodService goodServiceB;
    private final GoodService goodServiceC;

    public SimpleQualifierController(@Qualifier("goodServiceA") GoodService goodServiceA,
                                     @Qualifier("goodServiceB") GoodService goodServiceB,
                                     @Qualifier("goodServiceC") GoodService goodServiceC) {
        this.goodServiceA = goodServiceA;
        this.goodServiceB = goodServiceB;
        this.goodServiceC = goodServiceC;
    }

    @GetMapping("/doSomething")
    public void doSomething() {
        goodServiceA.doSomething();
        goodServiceB.doSomething();
        goodServiceC.doSomething();
    }

}
