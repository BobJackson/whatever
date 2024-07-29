package com.wangyousong.practice.whatever;

import com.wangyousong.practice.whatever.design.pattern.monad.Sex;
import com.wangyousong.practice.whatever.design.pattern.monad.User;
import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class UserTest {


    @Test
    void should_stat_user_age() {
        var u1 = new User("Bob", 32, Sex.MALE, "bob@gmail.com");
        var u2 = new User("Mary", 27, Sex.FEMALE, "mary@gmail.com");
        var u3 = new User("Jack", 39, Sex.MALE, "jack@gmail.com");
        var u4 = new User("Dary", 28, Sex.MALE, "dary@gmail.com");
        // TODO: impl it
        IntStream intStream = Stream.of(u1, u2, u3, u4)
                .mapToInt(User::age);
        IntSummaryStatistics statistics = intStream.summaryStatistics();
        System.out.println(statistics);
    }
}
