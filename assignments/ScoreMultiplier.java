package assignments;

import java.util.Arrays;

public class ScoreMultiplier {
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        // Direct reference assignments (no loop needed)
        playerScores[captainIndex] *= 2.0;       // Captain (2x points)
        playerScores[viceCaptainIndex] *= 1.5;   // Vice-Captain (1.5x points)
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
    }
}
