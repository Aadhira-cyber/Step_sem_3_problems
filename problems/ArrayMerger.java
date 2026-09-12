package problems;

import java.util.Arrays;

public class ArrayMerger {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int p1 = 0; // Pointer for arr1
        int p2 = 0; // Pointer for arr2
        int r = 0;  // Pointer for result array

        // Move through both arrays, choosing the smaller element
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] <= arr2[p2]) {
                result[r++] = arr1[p1++];
            } else {
                result[r++] = arr2[p2++];
            }
        }

        // Copy over remaining elements from arr1 if any left
        while (p1 < arr1.length) {
            result[r++] = arr1[p1++];
        }

        // Copy over remaining elements from arr2 if any left
        while (p2 < arr2.length) {
            result[r++] = arr2[p2++];
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] res1 = mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        System.out.println(Arrays.toString(res1));

        int[] res2 = mergeSortedArrays(new int[]{}, new int[]{1, 2, 3});
        System.out.println(Arrays.toString(res2));
    }
}
