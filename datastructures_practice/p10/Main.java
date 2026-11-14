package datastructures_practice.p10;

import java.util.Arrays;

public class Main {
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int write = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[write - 1]) {
                nums[write++] = nums[i];
            }
        }
        return write;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int len = removeDuplicates(nums);
        System.out.println("length = " + len);
        System.out.println("nums[0.." + (len - 1) + "] = " + Arrays.toString(Arrays.copyOf(nums, len)));
    }
}
