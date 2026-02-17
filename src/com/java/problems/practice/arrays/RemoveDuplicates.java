package com.java.problems.practice.arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] arr = {2,10,10,30,30,30};
        int n = arr.length;

        int i=0, j=1;

        for(; j<n; j++) {
            if(arr[i]!=arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

        int k = i+1;

        for (int k1 = 0; k1 < k; k1++) {
            System.out.print(arr[k1] + " ");
        }
    }
}
