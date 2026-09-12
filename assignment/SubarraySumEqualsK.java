package assignment;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        
        // Map stores: [Prefix Sum, Frequency of occurrence]
        Map<Integer, Integer> map = new HashMap<>();
        
        // Base case: initialization for an empty prefix
        map.put(0, 1);

        for (int num : nums) {
            prefixSum += num;

            // If (prefixSum - k) exists, it means a valid contiguous subarray matches k
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Record the current prefix sum frequency
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println("Total Subarrays: " + subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println("Total Subarrays: " + subarraySum(new int[]{1, -1, 0}, 0));
    }
}
