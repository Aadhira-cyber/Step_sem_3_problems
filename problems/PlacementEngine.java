package problems;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;
    private double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        // Derived from sample data: (CGPA * 10) + (Coding * 0.5)
        this.compositeScore = (cgpa * 10.0) + (codingScore * 0.5);
    }

    // Getters to allow reading fields (this clears the warnings!)
    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
    public int getCodingScore() { return codingScore; }
    public double getCompositeScore() { return compositeScore; }

    @Override
    public int compareTo(Candidate other) {
        // Sort in descending order of composite score
        return Double.compare(other.compositeScore, this.compositeScore);
    }

    @Override
    public String toString() {
        return name + " (" + compositeScore + ")";
    }
}

public class PlacementEngine {
    // Overloaded check 1: CGPA-only filter
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5; 
    }

    // Overloaded check 2: Combined borderline filter
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 65;
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        // Filter out eligible candidates
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted.add(c);
            }
        }

        // Convert list to array so we can use Arrays.sort()
        Candidate[] qualifiedArray = shortlisted.toArray(new Candidate[0]);
        
        // Sorts automatically based on our compareTo method (descending)
        Arrays.sort(qualifiedArray);

        // Format the final leaderboard string output
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < qualifiedArray.length; i++) {
            output.append((i + 1)).append(". ").append(qualifiedArray[i]);
            if (i < qualifiedArray.length - 1) {
                output.append(" | ");
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Candidate[] batch = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(batch));
    }
}
