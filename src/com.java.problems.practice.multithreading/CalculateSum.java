package com.java.problems.practice.multithreading;

import java.util.List;
import java.util.concurrent.Callable;

public class CalculateSum implements Callable<Integer> {

    List<Integer> numList;

    CalculateSum(List<Integer> numList) {
        this.numList = numList;
    }

    @Override
    public Integer call() throws Exception {
        return numList.stream().reduce(0, (a, b) -> a + b);
    }
}
