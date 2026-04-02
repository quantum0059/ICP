class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][]dp = new int[n+2][2];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
               int profit = 0;
               if(j==0){
                int buy = -prices[i]+dp[i+1][1];
                int skip = dp[i+1][0];
                profit = Math.max(buy, skip);
               }else{
                int sell = prices[i]+dp[i+2][0];
                int skip = dp[i+1][1];

                profit = Math.max(sell, skip);
               }

               dp[i][j] = profit;
            }
        }
        
        return dp[0][0];
    }
    static int helper(int[] prices, int idx, int state, int[][] dp){
        if(idx>=prices.length) return 0;

        if(dp[idx][state] != -1){
            return dp[idx][state];
        }
        
        int profit = 0;
        if(state == 0){
           int buy = -prices[idx]+helper(prices, idx+1, 1, dp);
           int skip = helper(prices, idx+1, 0, dp);
           profit = Math.max(buy, skip);
        }else{
            int sell = prices[idx]+helper(prices, idx+2, 0,dp);
            int skip = helper(prices, idx+1, 1, dp);
            profit = Math.max(sell, skip);
        }

        return dp[idx][state] = profit;
    }
}