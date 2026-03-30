class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        
        for(int idx1 = 1;idx1<=n;idx1++){
            for(int idx2=1;idx2<=m;idx2++){
                int take = 0;
                int notTake1=0;
                int notTake2 =0;
                if(text1.charAt(idx1-1) == text2.charAt(idx2-1)){
                    take = 1+dp[idx1-1][idx2-1];
                }else{
                    notTake1 = dp[idx1-1][idx2];
                    notTake2 = dp[idx1][idx2-1];
                }

                dp[idx1][idx2]  = take+Math.max(notTake1, notTake2);
            }
        }

        return dp[n][m];
    }

    static int helper(String text1, String text2, int idx1, int idx2, int[][] dp){
        if(idx1 < 0 || idx2<0){
            return 0;
        }

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        int take = 0;
        int notTake1=0;
        int notTake2 =0;
        if(text1.charAt(idx1) == text2.charAt(idx2)){
            take = 1+helper(text1, text2, idx1-1, idx2-1, dp);
        }else{
              notTake1 = helper(text1, text2, idx1-1, idx2, dp);
              notTake2 = helper(text1, text2, idx1, idx2-1, dp);
        }

        return dp[idx1][idx2] = take+Math.max(notTake1, notTake2);
    }
}