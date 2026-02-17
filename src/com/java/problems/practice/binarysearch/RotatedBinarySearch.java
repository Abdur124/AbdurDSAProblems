package com.java.problems.practice.binarysearch;

public class RotatedBinarySearch {

    public static void main(String[] args) {

        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        int target = 9;

        int index = rotatedBinarySearch(arr, target);
        System.out.println(target + " found at index " +index);
    }

    private static int rotatedBinarySearch(int[] arr, int target) {

        int low = 0, high = arr.length - 1, index = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                index = mid;
                break;
            }

            if(arr[low] < arr[mid]) {

                if(arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return index;
    }
}
