package com.java.problems.practice.multithreading;

public class PrintABC {

    public static void main(String[] args) {

        ABCPrinter printer = new ABCPrinter(5);
        ABCSemaphore semaphore = new ABCSemaphore(5);
        ABCPrinterLock printerLock = new ABCPrinterLock(5);

        Thread t1 = new Thread(printerLock::printA, "Thread-A");
        Thread t2 = new Thread(printerLock::printB, "Thread-B");
        Thread t3 = new Thread(printerLock::printC, "Thread-C");

        t1.start();
        t2.start();
        t3.start();
    }
}
