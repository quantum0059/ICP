class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        } 

        return helper(prices, fee, 1, 0, dp);
    }

    static int helper(int[] prices, int fee, int buy, int idx, int[][] dp){
        if(idx == prices.length) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];

        int profit = 0;

        if(buy == 1){
            int take = -prices[idx]+helper(prices, fee, 0, idx+1, dp);
            int skip = helper(prices, fee, 1, idx+1, dp);

            profit = Math.max(take, skip);
        }else{
            int take = prices[idx]-fee+helper(prices, fee, 1, idx+1, dp);
            int skip = helper(prices, fee, 0, idx+1, dp);

            profit = Math.max(take, skip);
        }

        return dp[idx][buy] = profit;
    }
}