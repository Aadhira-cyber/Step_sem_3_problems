package Assignments.week2;

public class WordReversalEncoder {
    public static String reverseEachWord(String sentence) {
        // Split sentence into words using a single space delimiter
        String[] words = sentence.split(" ");
        StringBuilder finalResult = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reversedWord = new StringBuilder();
            
            // Reversing the individual word using a loop
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }
            
            finalResult.append(reversedWord);
            
            // Append a space between words, but not after the last word
            if (i < words.length - 1) {
                finalResult.append(" ");
            }
        }
        
        String result = finalResult.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        // Test Case
        reverseEachWord("hello club");
    }
}
