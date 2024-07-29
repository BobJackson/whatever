package com.wangyousong.practice.whatever.design.pattern.factory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Getter
public enum CoinType {
    COPPER(CopperCoin::new),
    GOLDEN(GoldenCoin::new);

    private final Supplier<Coin> constructor;
}
