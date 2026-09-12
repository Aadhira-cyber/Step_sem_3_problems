package problems;

import java.util.Arrays;

public class ArrayRotator {
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;

        int n = nums.length;
        // Reduce unnecessary rotations if k is larger than the array length
        k = k % n; 

        int[] newArray = new int[n];

        // Map old positions to new rotated coordinates
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        // Copy values back to original array as requested
        for (int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotateArray(test1, 3)));

        int[] test2 = {1, 2};
        System.out.println(Arrays.toString(rotateArray(test2, 3)));
    }
}
