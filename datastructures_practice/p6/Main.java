package datastructures_practice.p6;

public class Main {
    static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int best = 0;
        for (int i = 1; i < prices.length; i++) {
            best = Math.max(best, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
