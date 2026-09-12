package problems;

public class DuplicateChecker {
    public static boolean containsDuplicate(int[] nums) {
        // Nested loop structure to compare all pairs
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Match found, exit early
                }
            }
        }
        return false; // All numbers are unique
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println("Contains Duplicate: " + containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println("Contains Duplicate: " + containsDuplicate(new int[]{1, 2, 3, 4}));
    }
}
