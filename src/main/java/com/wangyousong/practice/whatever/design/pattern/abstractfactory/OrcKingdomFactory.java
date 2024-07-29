package com.wangyousong.practice.whatever.design.pattern.abstractfactory;

public class OrcKingdomFactory implements KingdomFactory {
    @Override
    public Army createArmy() {
        return new OrcArmy();
    }

    @Override
    public Castle createCastle() {
        return new OrcCastle();
    }

    @Override
    public King createKing() {
        return new OrcKing();
    }
}
