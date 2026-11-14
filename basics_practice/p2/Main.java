package basics_practice.p2;

public class Main {
    static void check(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        if (word.equals(reversed)) {
            System.out.println(reversed + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String w : args) {
                check(w);
            }
        } else {
            check("level");
            check("java");
        }
    }
}
