package com.wangyousong.practice.whatever;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CompletableFutureTest {

    // use allOf then join, will not need to join all futures

    @Test
    void should_get_result_when_join_after_all_of() throws ExecutionException, InterruptedException {
        CompletableFuture<List<Map<String, Object>>> loadDataFuture = CompletableFuture.supplyAsync(this::loadData);
        CompletableFuture<Long> countFuture = CompletableFuture.supplyAsync(this::calcCount);
        CompletableFuture.allOf(loadDataFuture, countFuture).join();

        assertNotNull(loadDataFuture.get());
        assertNotNull(countFuture.get());
    }

    private List<Map<String, Object>> loadData() {
        try {
            TimeUnit.MICROSECONDS.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            return new ArrayList<>();
        }
        return List.of(Map.of("key1", "value1"), Map.of("key2", "value2"));
    }

    private Long calcCount() {
        return (long) (Math.random() * 1000);
    }

    // Using CompletableFuture as a Simple Future

    @Test
    void should_get_result() throws ExecutionException, InterruptedException {
        Future<String> completableFuture = calculateAsync();

        String result = completableFuture.get();
        assertEquals("Hello", result);
    }

    private Future<String> calculateAsync() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }

    @Test
    void should_get_result_if_known() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Hello");

        String result = completableFuture.get();

        assertEquals("Hello", result);
    }

    // CompletableFuture with Encapsulated Computation Logic

    @Test
    void should_get_result_when_supply_async() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

        assertEquals("Hello", future.get());
    }

    // Processing Results of Asynchronous Computations

    @Test
    void should_get_result_when_then_apply() {
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(result -> result + " World")
                .thenAccept(result -> assertEquals("Hello World", result));
    }

    @Test
    void should_get_null_when_consume_returned() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(result -> System.out.println("Computation returned: " + result));

        assertNull(future.get());
    }

    @Test
    void should_get_null_when_then_run() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenRun(() -> System.out.println("Hello World"));

        assertNull(future.get());
    }

    //  Combining Futures


    @Test
    void should_get_result_when_then_compose() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> result + " World"));

        assertEquals("Hello World", future.get());
    }

    @Test
    void should_get_result_when_then_combine() {
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(() -> " World"), (result1, result2) -> result1 + result2)
                .thenAccept(result -> assertEquals("Hello World", result));
    }

    // Difference Between thenApply() and thenCompose()


    @Test
    void should_get_result_when_then_apply_add_one() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> finalResult = compute().thenApply(s -> s + 1);

        assertEquals(11, finalResult.get());
    }

    @Test
    void should_get_result_when_then_compose_compute_another() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = compute().thenCompose(this::computeAnother);

        assertEquals(20, future.get());
    }

    private CompletableFuture<Integer> compute() {
        return CompletableFuture.supplyAsync(() -> 10);
    }

    private CompletableFuture<Integer> computeAnother(Integer i) {
        return CompletableFuture.supplyAsync(() -> 10 + i);
    }

    // Running Multiple Futures in Parallel

    @Test
    void should_get_result_when_multiple_futures() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        combinedFuture.get();

        assertTrue(future1.isDone());
        assertTrue(future2.isDone());
        assertTrue(future3.isDone());
    }

    @Test
    void should_get_result_when_multiple_futures_and_join() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        assertEquals("Hello Beautiful World", combined);
    }

    // Handling Errors

    @Test
    void should_get_result_when_handle_exception() throws ExecutionException, InterruptedException {
        String name = null;
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");

        assertEquals("Hello, Stranger!", completableFuture.get());
    }

    @Test
    void should_get_exception_when_complete_exceptionally() {
        CompletableFuture<Object> completableFuture = new CompletableFuture<>();

        completableFuture.completeExceptionally(new RuntimeException("Calculation failed!"));

        assertThrows(ExecutionException.class, completableFuture::get);
    }

    // Async Methods

    @Test
    void should_get_result_when_then_supply_async() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApplyAsync(result -> result + " World");

        assertEquals("Hello World", future.get());
    }
}
