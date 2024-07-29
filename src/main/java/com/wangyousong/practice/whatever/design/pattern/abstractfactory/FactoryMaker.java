package com.wangyousong.practice.whatever.design.pattern.abstractfactory;

public class FactoryMaker {

    public static KingdomFactory makeFactory(KingdomType type){
        return switch (type) {
            case ELF -> new ElfKingdomFactory();
            case ORC -> new OrcKingdomFactory();
        };
    }
}
