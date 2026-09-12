package assignment;

public class RotatedSortedArrayMin {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the right element, 
            // the minimum must be hidden in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Otherwise, the minimum is either at mid or in the left half.
            else {
                right = mid;
            }
        }

        return nums[left]; // Left converging point holds the minimum element
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println("Minimum Element: " + findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println("Minimum Element: " + findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println("Minimum Element: " + findMin(new int[]{11, 13, 15, 17}));
    }
}

