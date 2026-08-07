class Solution {
    int M = 1000000007;
    public int numTilings(int n) {
         int []dp = new int[1001];
        Arrays.fill(dp, -1);
        dp[1]=1;
        dp[2]=2;
        dp[3]=5;
        for(int i=4;i<n+1;i++){
            dp[i] = (int)(((2L*dp[i-1])%M+dp[i-3])%M);
        }
        return  dp[n];
    }
}