package sorting.p2;

import java.util.Arrays;

public class Main {
    static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                int t = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = t;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        int[][] tests = {{45, 90, 60, 75}, {80, 70, 60}, {10, 50, 30, 50, 20}};
        for (int[] marks : tests) {
            int swaps = prizeTable(marks);
            System.out.println(Arrays.toString(marks) + " swaps = " + swaps);
        }
    }
}
