package com.java.problems.practice.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCPrinterLock {

    private int N;
    private int count = 0;

    ABCPrinterLock(int N) {
        this.N = N;
    }

    private final Lock lock = new ReentrantLock();

    private final Condition condA = lock.newCondition();
    private final Condition condB = lock.newCondition();
    private final Condition condC = lock.newCondition();

    public void printA() {
        for (int i = 0; i < N; i++) {
            lock.lock();
            try{
                while(count%3 != 0) {
                    condA.await();
                }
                System.out.println(Thread.currentThread().getName() + ": A");
                count++;
                condB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printB() {
        for (int i = 0; i < N; i++) {
            lock.lock();
            try{
                while(count%3 != 1) {
                    condB.await();
                }
                System.out.println(Thread.currentThread().getName() + ": B");
                count++;
                condC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printC() {
        for (int i = 0; i < N; i++) {
            lock.lock();
            try{
                while(count%3 != 2) {
                    condC.await();
                }
                System.out.println(Thread.currentThread().getName() + ": C");
                count++;
                condA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
