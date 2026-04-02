class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][2];
        
        for(int[][] arr: dp){
            for(int[] a: arr){
                Arrays.fill(a, -1);
            }
        }
            return helper(prices, 0, 0, 1, dp);
    }
    static int helper(int[] prices, int idx, int state, int coolDown, int[][][] dp){
        if(idx==prices.length) return 0;

        if(dp[idx][state][coolDown] != -1){
            return dp[idx][state][coolDown];
        }

        if(coolDown == 0) {
            return dp[idx][state][coolDown] = helper(prices, idx+1, state, 1, dp);
        }
        
        int profit = 0;
        if(state == 0){
           int buy = -prices[idx]+helper(prices, idx+1, 1, coolDown, dp);
           int skip = helper(prices, idx+1, 0, coolDown, dp);
           profit = Math.max(buy, skip);
        }else{
            int sell = prices[idx]+helper(prices, idx+1, 0, 0, dp);
            int skip = helper(prices, idx+1, 1, coolDown, dp);
            profit = Math.max(sell, skip);
        }

        return dp[idx][state][coolDown] = profit;
    }
}