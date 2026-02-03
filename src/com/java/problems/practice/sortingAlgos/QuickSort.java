package com.java.problems.practice.sortingAlgos;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {3, 7, 1, 4, 9, 8};

        quickSort(arr, 0, arr.length - 1);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {

        if(low >= high) return;
        int partition = findPartition(arr, low, high);
        quickSort(arr, low, partition - 1);
        quickSort(arr, partition + 1, high);
    }

    private static int findPartition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = low -1;

        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
