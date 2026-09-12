package problems;

import java.util.Arrays;

public class TwoSumFinder {
    public static int[] twoSum(int[] nums, int target) {
        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Check subsequent elements to discover a matching pair
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j}; // Return indices immediately
                }
            }
        }
        return new int[]{-1, -1}; // Fallback case if no pair is found
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }
}

