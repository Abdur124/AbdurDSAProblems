package com.java.problems.practice.java8;

import java.util.Arrays;
import java.util.List;

public class Java8Practice {

    public static void main(String[] args) {

        // count how many numbers are greater than 3
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        long count = nums.stream().filter(num -> num > 3).count();
        System.out.println(count);

        // sum of even numbers in list

        long sum = nums.stream().filter(num -> num %2 == 0).reduce(0, Integer::sum);
        System.out.println(sum);

        //max number

        List<Integer> numList = Arrays.asList(3, 7, 2, 9, 5);

        System.out.println(numList.stream().max(Integer::compare).get());
    }


}
