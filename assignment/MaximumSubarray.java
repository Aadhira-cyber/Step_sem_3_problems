package assignment;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the existing subarray or start fresh
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // Keep a running record of the absolute highest sum seen
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println("Max Subarray Sum: " + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("Max Subarray Sum: " + maxSubArray(new int[]{-3, -1, -2}));
    }
}
