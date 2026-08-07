class Solution {
    int dp[];
    int M = 1000000007;
    int helper(int n){
        if(n==1 || n==2){
            return n;
        }

        if(n==3) return 5;
        if(dp[n] != -1) return dp[n];

        return dp[n] = (int)(((2L * helper(n - 1)) % M
                            + helper(n - 3)) % M);

    }
    public int numTilings(int n) {
        dp = new int[1001];
        Arrays.fill(dp, -1);

        return helper(n);
    }
}