package com.java.problems.practice.sortingAlgos;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {3, 7, 1, 4, 9, 8};
        int n = arr.length;

        for(int i=n/2-1; i>=0; i--) {
            heapify(arr, n, i);
        }

        for(int i=n-1; i>0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void heapify(int[] arr, int heapSize, int rootPos) {

        int largest = rootPos;

        int leftPos = rootPos * 2 + 1;
        int rightPos = rootPos * 2 + 2;

        if(leftPos < heapSize && arr[leftPos] > arr[largest]) {
            largest = leftPos;
        }

        if(rightPos < heapSize && arr[rightPos] > arr[largest]) {
            largest = rightPos;
        }

        if(largest != rootPos) {
            int temp = arr[largest];
            arr[largest] = arr[rootPos];
            arr[rootPos] = temp;
            heapify(arr, heapSize, largest);
        }
    }
}
