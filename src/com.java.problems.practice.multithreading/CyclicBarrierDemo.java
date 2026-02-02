package com.java.problems.practice.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3, () ->
        {
            System.out.println("All threads done, moving to phase 2");
        });

        Runnable r = () -> {

            try {
                System.out.println(Thread.currentThread().getName() + " is running task 1");

                barrier.await();

                System.out.println(Thread.currentThread().getName() + " is running task 2");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };

        Thread t1 = new Thread(r, "thread1");
        Thread t2 = new Thread(r, "thread2");
        Thread t3 = new Thread(r, "thread3");

        t1.start();
        t2.start();
        t3.start();
    }
}
