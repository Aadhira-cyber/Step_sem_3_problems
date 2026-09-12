package assignments;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() { return name; }
    public int getMatchesPlayed() { return matchesPlayed; }
    public boolean isInjured() { return injured; }

    @Override
    public int compareTo(Player other) {
        // Sort descending by batting average points
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    @Override
    public String toString() {
        return name;
    }
}

public class AutoDraftEngine {
    // Overloaded filter rules mapped from scenario details
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        List<Player> pool = new ArrayList<>();

        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                pool.add(p);
            }
        }

        Player[] draftableArray = pool.toArray(new Player[0]);
        Arrays.sort(draftableArray); // Native merge sort integration via Comparable interface

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            output.append((i + 1)).append(". ").append(draftableArray[i]);
            if (i < draftableArray.length - 1) {
                output.append(" | ");
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Player[] lineup = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(lineup));
    }
}
