package com.java.problems.practice.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        Runnable r = () ->  {
            try{
                System.out.println(Thread.currentThread().getName() + "->" +countDownLatch.getCount());
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        };

        Thread t1 = new Thread(r, "Thread1");
        Thread t2 = new Thread(r, "Thread2");
        Thread t3 = new Thread(r, "Thread3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Main Thread Waiting.....");
        countDownLatch.await();
    }
}
