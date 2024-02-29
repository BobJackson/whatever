package com.wangyousong.practice.whatever.design.pattern.monad;

import java.util.Objects;

public class App {
    public static void main(String[] args) {
        var user = new User("user", 24, Sex.FEMALE, "foobar.com");
        String result = Validator.of(user)
                .validator(User::name, Objects::nonNull, "name is null")
                .validator(User::name, name -> !name.isEmpty(), "name is empty")
                .validator(User::email, email -> !email.contains("@"), "email doesn't contains '@'")
                .validator(User::age, age -> age > 20 && age < 30, "age isn't between...")
                .get()
                .toString();
        System.out.println(result);
    }
}
