class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;

        int[][][] dp = new int[n][2][3];
        for(int[][] arr: dp){
            for(int[] a: arr){
                Arrays.fill(a, -1);
            }
        }

        return helper(prices, 0, 1, 2, dp);
    }

    static int helper(int[] prices, int idx, int buy, int count, int[][][]dp){
        if(count == 0) return 0;
        if(idx == prices.length) return 0;

        if(dp[idx][buy][count] != -1) return dp[idx][buy][count];
        
        int profit =0;
        if(buy==1){

          int take = -prices[idx] + helper(prices, idx+1, 0, count, dp);
          int skip = helper(prices, idx+1, 1, count, dp);

          profit = Math.max(take, skip);
        }else{//when you buy you have to sell it first before buy another stock
            int take = prices[idx] + helper(prices, idx+1, 1, count-1, dp);

            int skip = helper(prices, idx+1, 0, count, dp);

            profit = Math.max(take, skip);
        }

        return dp[idx][buy][count] = profit;
    }
}