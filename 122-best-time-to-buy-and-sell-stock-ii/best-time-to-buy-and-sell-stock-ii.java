class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

         for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return helper(prices, 0, 1, dp);
    }

    static int helper(int[] prices, int idx, int state, int[][] dp){
        if(idx>=prices.length) return 0;

        if(dp[idx][state] != -1){
            return dp[idx][state];
        }
        
        int ans =0;
        if(state == 1){
          int buy = -prices[idx]+helper(prices, idx+1, 0, dp);
          int skip = helper(prices, idx+1, 1, dp);
          ans = Math.max(buy, skip);
        }else{
            int sell = prices[idx]+helper(prices, idx+1, 1, dp);
            int skip = helper(prices, idx+1, 0, dp);
            ans = Math.max(sell, skip);
        }

        

        return dp[idx][state] = ans;
    }
}