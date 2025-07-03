package arrayDSA;

public class BuyAndSellStocks {
    public static int getMaxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) { // profit
                int profit = prices[i] - buyPrice; // today's profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(getMaxProfit(prices));
    }
}
