package basics_practice.p4;

import java.util.Arrays;

public class Main {
    static void reverse(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] tokens = {11, 22, 33, 44};
        reverse(tokens);
        System.out.println(Arrays.toString(tokens));
    }
}
