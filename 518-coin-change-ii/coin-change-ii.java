class Solution {
    long [][] dp;
    public int change(int amount, int[] coins) {
          dp = new long[coins.length][amount+1];

          for(long[] arr: dp){
            Arrays.fill(arr, -1);
          }
          return (int)helper(coins, 0, amount);


    }

    long helper(int[] coins, int idx, int amount){
        if(idx>=coins.length){
            return amount == 0 ? 1:0;
        }
        if(amount == 0) return 1;
        if(dp[idx][amount] != -1) return dp[idx][amount];
        long ans = helper(coins, idx+1, amount);
        if(amount>=coins[idx]){
           ans += helper(coins, idx, amount-coins[idx]);
        }

        return dp[idx][amount] = ans;
    }
}