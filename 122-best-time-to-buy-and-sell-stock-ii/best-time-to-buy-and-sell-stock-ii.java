class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;

        int[][] dp = new int[n+1][2];

        for(int i=0;i<2;i++){
            dp[n][0] = 0;
        }


        for(int idx=n-1;idx>=0;idx--){
            for(int buy =0 ;buy<=1;buy++){
                int profit = 0;
                if(buy == 1){
                    int take = -prices[idx] + dp[idx+1][0];
                    int skip = dp[idx+1][1];

                    profit = Math.max(take, skip);
                }else{
                    int take = prices[idx] + dp[idx+1][1];
                    int skip = dp[idx+1][0];

                    profit = Math.max(take, skip);
                }

                dp[idx][buy] = profit;
            }
        }
        return dp[0][1];

    }
}