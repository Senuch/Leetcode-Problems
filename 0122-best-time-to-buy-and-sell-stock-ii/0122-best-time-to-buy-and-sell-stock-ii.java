class Solution {

    public int maxProfit(int[] Arr) {
        //return maxProfitHelper(0, true, prices, new int[prices.length + 1][2]);
        int n = Arr.length;
        // Create a 2D array for dynamic programming with dimensions [n+1][2]
        long[][] dp = new long[n + 1][2];

        // Initialize the entire dp table with -1
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Base condition: If we have no stocks to buy or sell, profit is 0
        dp[n][0] = dp[n][1] = 0;

        long profit = 0;

        // Iterate through the array in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], Arr[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }
        return (int)dp[0][0]; // The maximum profit is stored at dp[0][0]
    }
}
