package com.wangyousong.practice.whatever.design.pattern.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {
        log.info("The alchemist begins his work.");
        var coin1 = CoinFactory.getCoin(CoinType.COPPER);
        var coin2 = CoinFactory.getCoin(CoinType.GOLDEN);
        log.info(coin1.getDescription());
        log.info(coin2.getDescription());
    }
}
