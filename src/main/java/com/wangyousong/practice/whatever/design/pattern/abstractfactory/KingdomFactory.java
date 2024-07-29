package com.wangyousong.practice.whatever.design.pattern.abstractfactory;

public interface KingdomFactory {
    Army createArmy();

    Castle createCastle();

    King createKing();
}
