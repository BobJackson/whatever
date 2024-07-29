package com.wangyousong.practice.whatever.design.pattern.factory;

public class CoinFactory {

    public static Coin getCoin(CoinType type) {
        return type.getConstructor().get();
    }
}
