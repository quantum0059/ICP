class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;

        int[][] dp = new int[n][2];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return helper(prices, 0, 1, dp);
    }

    static int helper(int[] prices, int idx, int buy, int[][] dp){
        if(idx == prices.length) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];
        
        int profit =0;
        if(buy == 1){

          int take = -prices[idx] + helper(prices, idx+1, 0, dp);
          int skip = helper(prices, idx+1, 1, dp);

          profit = Math.max(take, skip);
        }else{//when you buy you have to sell it first before buy another stock
            int take = prices[idx] + helper(prices, idx+1, 1, dp);

            int skip = helper(prices, idx+1, 0, dp);

            profit = Math.max(take, skip);
        }

        return dp[idx][buy] = profit;
    }
}