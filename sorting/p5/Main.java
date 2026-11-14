package sorting.p5;

import java.util.Arrays;

public class Main {
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int r : rolls) {
            count[r]++;
        }
        StringBuilder sb = new StringBuilder("Counts:");
        for (int v = 1; v <= 6; v++) {
            sb.append(" ").append(v).append(":").append(count[v]);
        }
        System.out.println(sb);
        int[] result = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                result[idx++] = v;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] sorted = diceSort(new int[]{4, 1, 6, 4, 2, 1, 4});
        System.out.println("Sorted: " + Arrays.toString(sorted));
        sorted = diceSort(new int[]{6, 6, 5, 3, 3, 3});
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
