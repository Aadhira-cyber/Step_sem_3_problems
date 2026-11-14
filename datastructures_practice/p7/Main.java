package datastructures_practice.p7;

public class Main {
    static int searchInsertPosition(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsertPosition(nums, 5));
        System.out.println(searchInsertPosition(nums, 2));
        System.out.println(searchInsertPosition(nums, 7));
        System.out.println(searchInsertPosition(nums, 0));
    }
}
