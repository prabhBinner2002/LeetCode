package arrayDSA.assignmentQs;

public class maxProfit {
    public static int maxProfit(int[] arr) {
        int buyPrice = arr[0], maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            if(buyPrice < arr[i]) {
                int profit = arr[i] - buyPrice;
                maxProfit = Math.max(profit, maxProfit);
            } else {
                buyPrice = arr[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 6, 4,  3, 1};
        System.out.println(maxProfit(prices));
    }
}
