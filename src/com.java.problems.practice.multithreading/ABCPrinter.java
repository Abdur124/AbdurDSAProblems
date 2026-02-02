package com.java.problems.practice.multithreading;

public class ABCPrinter {

    private int N;
    private int count = 1;
    private int num = 0;

    public ABCPrinter(int N) {
        this.N = N;
    }

    public synchronized void printA() {
        while(count <= N) {
            while(num % 3 != 0) {
                try{
                    wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

                System.out.println(Thread.currentThread().getName() + ": " + "A");
                num++;
                notifyAll();
        }
    }

    public synchronized void printB() {
        while(count <= N) {
            while(num % 3 != 1) {
                try{
                    wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

                System.out.println(Thread.currentThread().getName() + ": " + "B");
                num++;
                notifyAll();
        }
    }

    public synchronized void printC() {
        while(count <= N) {
            while(num % 3 != 2) {
                try{
                    wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

                System.out.println(Thread.currentThread().getName() + ": " + "C");
                num++;
                count++;
                notifyAll();
        }
    }
}
