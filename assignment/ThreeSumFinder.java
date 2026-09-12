package assignment;

import java.util.*;

public class ThreeSumFinder {
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums); // Setup step: Sort to handle duplicates easily
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(new int[]{nums[i], nums[left], nums[right]});
                    
                    // Skip duplicates for the second and third elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Need a larger value
                } else {
                    right--; // Need a smaller value
                }
            }
        }

        return triplets.toArray(new int[triplets.size()][]);
    }

    public static void main(String[] args) {
        // Test Cases
        int[][] res1 = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(Arrays.deepToString(res1));

        int[][] res2 = threeSum(new int[]{0, 0, 0});
        System.out.println(Arrays.deepToString(res2));
    }
}
