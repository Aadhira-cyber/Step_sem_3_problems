package week1;
public class PalindromeChecker {

    public static void main(String[] args) {
        runCheck("madam");
        runCheck("hello");
    }

    public static void runCheck(String text) {
        System.out.println("Input: \"" + text + "\"");
        System.out.print("Iterative: " + (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));
        System.out.print(" | Recursive: " + (isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome"));
        System.out.println(" | Array Reversal: " + (isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome"));
        System.out.println();
    }

    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return text.equals(new String(reversed));
    }
}
