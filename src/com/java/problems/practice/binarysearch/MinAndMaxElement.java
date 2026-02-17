package com.java.problems.practice.binarysearch;

public class MinAndMaxElement {

    public static void main(String[] args) {

        int[] arr = {2, 5, 6, 0, 0, 1, 2};

        int n = arr.length;
        int index = findMinimum(arr);
        System.out.println("Min Element " +arr[index]);
        System.out.println("Max Element " +arr[(index - 1 + n)%n]);
    }

    public static int findMinimum(int[] arr) {

        int low = 0, high = arr.length - 1;

        while(low < high) {

            int mid = low + (high - low) / 2;

            if(arr[mid] > arr[high]) {
                low = mid + 1;
            } else if(arr[mid] < arr[high]) {
                high = mid;
            } else { // with duplicates, arr[mid] == arr[high]
                high--;
            }
        }

        return low;
    }
}
