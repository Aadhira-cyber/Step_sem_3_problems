package problems;

public class StockTrader {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        // One pass traversal through daily prices
        for (int i = 1; i < prices.length; i++) {
            // Update lowest price seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate potential profit if sold today
                int currentProfit = prices[i] - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println("Max Profit: " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Max Profit: " + maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}

