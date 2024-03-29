class Solution {
    public int maxProfit(int[] prices) {
        int purchase = prices[0];
        int maxProfit = 0;
        for(int i = 1; i<prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - purchase);
            if(purchase > prices[i]) {
                purchase = prices[i];
            }
        }
        
        return maxProfit;
    }
}