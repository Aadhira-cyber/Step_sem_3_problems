package sorting.p1;

import java.util.Arrays;

public class Main {
    static void lineUp(int[] heights) {
        int n = heights.length;
        for (int pass = 1; pass <= n - 1; pass++) {
            boolean swapped = false;
            for (int j = 0; j < n - pass; j++) {
                if (heights[j] > heights[j + 1]) {
                    int t = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = t;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        lineUp(new int[]{4, 2, 5, 1});
        System.out.println();
        lineUp(new int[]{1, 3, 2, 4});
        System.out.println();
        lineUp(new int[]{9, 7, 8, 3, 5});
    }
}
