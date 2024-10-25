package com.wangyousong.practice.whatever;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DataFakerTest {

    @Test
    void should_fake() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String streetAddress = faker.address().streetAddress();

        assertNotNull(name);
        assertNotNull(firstName);
        assertNotNull(lastName);
        assertNotNull(streetAddress);
    }
}
