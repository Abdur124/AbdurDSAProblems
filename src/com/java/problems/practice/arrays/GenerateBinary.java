package com.java.problems.practice.arrays;

import java.util.*;

public class GenerateBinary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        generateBinary(n);
    }

    public static void generateBinary(int n) {

        Queue<String> queue = new LinkedList<>();
        List<String> res = new ArrayList<>();
        queue.offer("1");

        for(int i=0; i<n; i++) {

            String current = queue.poll();
            res.add(current);

            queue.offer(current + "0");
            queue.offer(current + "1");
        }

        for(int i=0; i<res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
