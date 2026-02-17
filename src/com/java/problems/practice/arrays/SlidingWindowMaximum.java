package com.java.problems.practice.arrays;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

            int[] nums = {1,3,-1,-3,5,3,6,7};
            int k = 3;
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int count = 0;

            Deque<Integer> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {

                if(!queue.isEmpty() && queue.peekFirst() == i-k) {
                    queue.pollFirst();
                }

                while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }

                queue.offer(i);

                if(i >= k - 1) {
                    res[count] = nums[queue.peekFirst()];
                    count++;
                }
            }

            System.out.println("Sliding Window Maximum.....");

            for(int j=0; j<n-k+1; j++) {
                System.out.print(res[j] + " ");
            }
    }
}
