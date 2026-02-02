package com.java.problems.practice.multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting order amount");
            return 1000;
        }).thenApply((amount) -> {
            System.out.println("Applying GST");
            return amount.doubleValue() + (amount.doubleValue() * 0.18);
        }).thenApply((amount) -> {
            System.out.println("Applying Discount");
            return amount.doubleValue() - (amount.doubleValue() * 0.10);
        }).thenAccept((finalAmount) -> System.out.println("Final Amount: " +finalAmount))
                .thenRun(() -> System.out.println("Billing Completed...!!"))
                .join();
    }
}
