package Assignments.week1;

public class TypingAccuracy {
    public static void checkTypingAccuracy(String original, String typed) {
        int totalChars = original.length();
        int matched = 0;
        int firstMismatchPos = -1;

        for (int i = 0; i < totalChars; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                // Store the 1-based position of the first mistake
                firstMismatchPos = i + 1; 
            }
        }

        double accuracy = ((double) matched / totalChars) * 100;

        System.out.print("Matched: " + matched + "/" + totalChars + " | ");
        System.out.printf("Accuracy: %.2f%% | ", accuracy);
        
        if (firstMismatchPos != -1) {
            char origChar = original.charAt(firstMismatchPos - 1);
            char typedChar = typed.charAt(firstMismatchPos - 1);
            System.out.println("First Mismatch at position " + firstMismatchPos + " ('" + origChar + "' vs '" + typedChar + "')");
        } else {
            System.out.println("No Mismatches");
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        checkTypingAccuracy("hello world", "hello worlt");
        
        // Test Case 2
        checkTypingAccuracy("coding", "coding");
    }
}
