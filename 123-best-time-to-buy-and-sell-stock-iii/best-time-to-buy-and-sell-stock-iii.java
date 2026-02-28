class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;

        int[][][] dp = new int[n+1][2][3];
        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                dp[i][j][0] = 0;
            }
        }
        for(int i=0;i<2;i++){
           for(int j=0;j<3;j++){
                dp[0][i][j] = 0;
           }
        }

        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
                for(int count=1;count<=2;count++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max((-prices[idx]+dp[idx+1][0][count]), (dp[idx+1][1][count]));
                    }else{
                        profit = Math.max((prices[idx]+dp[idx+1][1][count-1]), dp[idx+1][0][count]);
                    }

                    dp[idx][buy][count] = profit;
                }
            }
        }

        return dp[0][1][2];
    }

}