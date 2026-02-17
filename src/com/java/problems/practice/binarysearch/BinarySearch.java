package com.java.problems.practice.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {3, 7, 1, 4, 9, 8, 6, 2};
        int target = 8;

        int index = findTarget(arr, target);
        System.out.println(target + " found at index " +index);
    }

    public static int findTarget(int[] arr, int target) {

        int low = 0, mid = -1;
        int high = arr.length - 1;

        while(low <= high) {

            mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return mid;
    }
}
