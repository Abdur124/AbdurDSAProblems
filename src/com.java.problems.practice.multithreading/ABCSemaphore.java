package com.java.problems.practice.multithreading;

import java.util.concurrent.Semaphore;

public class ABCSemaphore {

    private int N;

    ABCSemaphore(int N) {
        this.N = N;
    }

    private final Semaphore semA = new Semaphore(1);
    private final Semaphore semB = new Semaphore(0);
    private final Semaphore semC = new Semaphore(0);

    public void printA() {

        for (int i = 0; i < N; i++) {
            try {
                semA.acquire();
                System.out.println(Thread.currentThread().getName() + ": " + "A");
                semB.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {

        for (int i = 0; i < N; i++) {
            try {
                semB.acquire();
                System.out.println(Thread.currentThread().getName() + ": " + "B");
                semC.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {

        for (int i = 0; i < N; i++) {
            try {
                semC.acquire();
                System.out.println(Thread.currentThread().getName() + ": " + "C");
                semA.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
