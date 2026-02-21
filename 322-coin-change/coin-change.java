class Solution {
    static final int INF = (int)1e9;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // initialize
        for (int j = 1; j <= amount; j++) {
            dp[n][j] = INF;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // fill table
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int sum = 1; sum <= amount; sum++) {

                int notPick = dp[idx + 1][sum];
                int pick = INF;

                if (coins[idx] <= sum) {
                    pick = 1 + dp[idx][sum - coins[idx]];
                }

                dp[idx][sum] = Math.min(pick, notPick);
            }
        }

        return dp[0][amount] >= INF ? -1 : dp[0][amount];
    }
}