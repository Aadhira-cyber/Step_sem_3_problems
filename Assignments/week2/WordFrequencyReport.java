package Assignments.week2;

import java.util.*;

public class WordFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        // Define standard stop-words filter list
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        // Normalize text: convert to lowercase and strip periods/commas
        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");

        // Split words by any whitespace pattern
        String[] words = cleanedText.split("\\s+");

        // Count frequency of unique non-stop words
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        // Convert Map entries to a List to enable sorting by values
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        // Sort by count in descending order
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Print final counts
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Test Case
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
