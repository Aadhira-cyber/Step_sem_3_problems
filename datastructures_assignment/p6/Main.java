package datastructures_assignment.p6;

public class Main {
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int run = 0;
        int longest = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                run++;
                longest = Math.max(longest, run);
            } else {
                run = 0;
            }
        }
        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        int[] a = attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        System.out.println("Present: " + a[0] + ", Longest streak: " + a[1]);
        int[] b = attendanceSummary(new int[]{0, 0, 0});
        System.out.println("Present: " + b[0] + ", Longest streak: " + b[1]);
    }
}
