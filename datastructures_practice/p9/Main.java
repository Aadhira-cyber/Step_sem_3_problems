package datastructures_practice.p9;

public class Main {
    static int[] pairSumSorted(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum == target) {
                return new int[]{nums[lo], nums[hi]};
            }
            if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return null;
    }

    static void show(int[] pair) {
        if (pair == null) {
            System.out.println("Not Found");
        } else {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }

    public static void main(String[] args) {
        show(pairSumSorted(new int[]{-4, -1, 0, 3, 5, 9}, 4));
        show(pairSumSorted(new int[]{1, 2, 3}, 100));
    }
}
