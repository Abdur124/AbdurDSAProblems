package com.java.problems.practice.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ComputeSumExecutor {

    private static long sum = 0;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);


        List<Integer> numList = new ArrayList<>();
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            numList.add(i);
        }

        int counter = 1, start = 0;

        for(int i=0; i<50; i=i+10) {

                Future<Integer> future = executor.submit(new CalculateSum(numList.subList(i, i+10)));
                futures.add(future);
        }

        for(Future<Integer> future : futures) {
            try {
                sum += (future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total sum: " + sum);

        executor.shutdown();
    }


}
