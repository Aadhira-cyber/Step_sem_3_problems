package Assignments.week1;
public class TrafficStreak {
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("No log data available.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                // Check if the streak that just ended is the longest
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestColor = currentColor;
                }
                // Reset tracker for the new character
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }
        }

        // Final check for the last character streak sequence
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        // Test Case 1
        findLongestStreak("RRGGGYRR");
        
        // Test Case 2
        findLongestStreak("RRRRYYGG");
    }
}

