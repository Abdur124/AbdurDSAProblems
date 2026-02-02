package com.java.problems.practice.multithreading;

import java.util.*;

class PrintNumbers {

    public static void main(String[] args) {

            OddEvenPrinter printer = new OddEvenPrinter(10);

            Thread t1 = new Thread(printer::printOdd, "oddNum");
            Thread t2 = new Thread(printer::printEven, "evenNum");

            t1.start();
            t2.start();
    }
}