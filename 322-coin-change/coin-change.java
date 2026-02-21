class Solution {
    static final int INF = (int)1e9;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        int ans =  helper(coins, dp, amount, 0);
        return ans == INF ? -1:ans;
    }

    static int helper(int[] coins, int[][] dp, int sum, int idx){
        if(sum<0) return INF;
        if(sum == 0) return 0;
        if(idx==coins.length){
            return INF;
        }
        if(dp[idx][sum] != -1) return dp[idx][sum];
       
        int  pick = 1+ helper(coins, dp, sum-coins[idx], idx);
       
        int notPick = helper(coins, dp, sum, idx+1);

        return dp[idx][sum] = Math.min(pick,notPick);
    }
}