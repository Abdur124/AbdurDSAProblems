package com.java.problems.practice.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdvancedProblems {

    public static void main(String[] args) {

        List<List<Integer>> nums = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5)
        );

        List<Integer> res = nums.stream().flatMap(List::stream).collect(Collectors.toList());

        res.forEach(System.out::println);

        //square each number and give sum

        List<Integer> numList = Arrays.asList(1, 2, 3, 4);

        int sum = numList.stream().mapToInt(num -> num * num).reduce(0, Integer::sum);
        System.out.println(sum);

        // find maximum

        List<Integer> nums2 = Arrays.asList(3, 7, 2, 9);

        System.out.println(nums2.stream().max(Integer::compare).orElse(-1));

        //parallel streams usage

        List<Integer> nums3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int squareSum = nums3.parallelStream().mapToInt(num -> num * num).sum();
        System.out.println(squareSum);
    }
}
