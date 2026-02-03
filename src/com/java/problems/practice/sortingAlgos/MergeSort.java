package com.java.problems.practice.sortingAlgos;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {3, 7, 1, 4, 9, 8};
        mergeSort(arr, 0, arr.length - 1);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {

            if(low >= high) {
                return;
            }

            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            mergeArrays(arr, low, mid, high);
        }

    private static void mergeArrays(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            arr[low + l] = temp[l];
        }
    }
}
