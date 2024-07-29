package com.wangyousong.practice.whatever.design.pattern.monad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;


public class Validator<T> {
    private final T obj;
    private final List<Throwable> exceptions = new ArrayList<>();

    private Validator(T obj) {
        this.obj = obj;
    }

    public static <T> Validator<T> of(T obj) {
        return new Validator<>(Objects.requireNonNull(obj));
    }

    public <U> Validator<T> validator(
            Function<? super T, ? extends U> projection,
            Predicate<? super U> validation,
            String message
    ) {
        return validator(projection.andThen(validation::test)::apply, message);
    }

    private Validator<T> validator(Predicate<? super T> validation, String message) {
        if (!validation.test(obj)) {
            exceptions.add(new IllegalStateException(message));
        }
        return this;
    }

    public T get() {
        if (exceptions.isEmpty()) {
            return obj;
        }
        var e = new IllegalStateException();
        exceptions.forEach(e::addSuppressed);
        throw e;
    }

}
