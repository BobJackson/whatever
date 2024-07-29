package com.wangyousong.practice.whatever.design.pattern.abstractfactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        KingdomFactory makeFactory = FactoryMaker.makeFactory(KingdomType.ELF);
        Army army = makeFactory.createArmy();
        Castle castle = makeFactory.createCastle();
        King king = makeFactory.createKing();
        log.info(army.getDescription());
        log.info(castle.getDescription());
        log.info(king.getDescription());

        makeFactory = FactoryMaker.makeFactory(KingdomType.ORC);
        army = makeFactory.createArmy();
        castle = makeFactory.createCastle();
        king = makeFactory.createKing();
        log.info(army.getDescription());
        log.info(castle.getDescription());
        log.info(king.getDescription());
    }
}
