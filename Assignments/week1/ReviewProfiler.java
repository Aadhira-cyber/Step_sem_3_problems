package Assignments.week1;

public class ReviewProfiler {
    public static void classifyWordLengths(String review) {
        // Split by one or more whitespace spaces
        String[] words = review.split("\\s+");
        
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {
            // Remove common punctuation to accurately count letters
            word = word.replaceAll("[^a-zA-Z]", "");
            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortWords++;
            } else if (length >= 5 && length <= 8) {
                mediumWords++;
            } else if (length >= 9) {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords + " | Medium: " + mediumWords + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        // Test Case
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}

