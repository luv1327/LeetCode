package NeetCode150.SlidingWindow;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int lowest_price = prices[0];
        for(int i = 0;i < n;i++){
            int currentProfit = prices[i] - lowest_price;
            maxProfit = Math.max(maxProfit,currentProfit);
            lowest_price = Math.min(lowest_price,prices[i]);
        }
        return maxProfit;
    }
}
