package com.autocat.multithreadexample.service;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;

class AsyncCouponServiceTest {

    @Test
    void completableFuture_test(){
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World")
                .thenApply(String::toUpperCase)
                .thenAccept(s -> System.out.println(s + "!!"));
    }

    @Test
    void completableFuture_exceptionally_test(){
        CompletableFuture.supplyAsync(() -> {throw new RuntimeException("Error");})
                .exceptionally(throwable -> {
                    System.out.println("Error occurred");
                    return "error";
                })
                .thenApply(s -> s + " world")
                .thenApply(String::toUpperCase)
                .thenAccept(System.out::println);
    }


}