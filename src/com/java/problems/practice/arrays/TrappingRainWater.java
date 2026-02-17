package com.java.problems.practice.arrays;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] arr = {4, 2, 0, 3, 2, 5};
        int area = findMaxArea(arr);
        System.out.println(area);
    }

    public static int findMaxArea(int[] height) {

        int low = 0, high = height.length - 1;
        int leftMax = 0, rightMax = 0, area = 0;

        while(low < high) {

            if(height[low] < height[high]) {

                if(height[low] >= leftMax) {
                    leftMax = height[low];
                } else {
                    area+=(leftMax - height[low]);

                }

                low++;
            } else {
                if(height[high] >= rightMax) {
                    rightMax = height[high];
                } else {
                    area+=(rightMax - height[high]);

                }

                high--;
            }
        }

        return area;
    }
}
