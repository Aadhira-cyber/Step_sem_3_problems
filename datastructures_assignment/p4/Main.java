package datastructures_assignment.p4;

public class Main {
    static int lowerBound(int[] scores, int value) {
        int lo = 0;
        int hi = scores.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (scores[mid] >= value) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        return lowerBound(scores, high + 1) - lowerBound(scores, low);
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}
