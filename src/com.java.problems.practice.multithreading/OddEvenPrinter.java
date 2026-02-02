package com.java.problems.practice.multithreading;

import java.util.*;

public class OddEvenPrinter {

    private int number;
    private int limit;

    OddEvenPrinter(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() {

        while (number <= limit) {
            while(number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(number <= limit) {
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                notify();
            }
        }
    }

    public synchronized void printEven() {

        while (number <= limit) {
            while(number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(number <= limit) {
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                notify();
            }
        }
    }
}