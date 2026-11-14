package sorting.p3;

import java.util.Arrays;

public class Main {
    static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int book = books[i];
            int j = i - 1;
            while (j >= 0 && books[j] > book) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = book;
            System.out.println("After placing " + book + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        shelf(new int[]{30, 10, 40, 20});
        System.out.println();
        shelf(new int[]{5, 4, 3, 2, 1});
    }
}
