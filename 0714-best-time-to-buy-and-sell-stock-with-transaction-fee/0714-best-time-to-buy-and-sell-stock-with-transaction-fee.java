class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];


        dp[n][0] = dp[n][1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                int profit = 0;
                if(j == 0) {
                    profit = Math.max(-prices[i] + dp[i + 1][1], dp[i + 1][0]);
                }else {
                    profit = Math.max(prices[i] + dp[i + 1][0] - fee, dp[i + 1][1]);
                }
                
                dp[i][j] = profit;
            }
        }
        
        return dp[0][0];
    }
}