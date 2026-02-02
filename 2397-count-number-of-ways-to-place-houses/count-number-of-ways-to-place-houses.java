class Solution {
    public static long MOD = 1_000_000_007;
    public long helper(int n , long[] dp){
        if(n==1) return 2;
        if(n==2) return 3;

        if(dp[n] != -1) return dp[n];

        dp[n] = (helper(n-1, dp)+helper(n-2, dp))%MOD;

        return dp[n];
    }
    public int countHousePlacements(int n) {
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        long k = helper(n, dp);
        long ans = (k*k)%MOD;
        return (int) ans;
    }
}