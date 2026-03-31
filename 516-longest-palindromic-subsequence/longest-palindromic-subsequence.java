class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int take = 0;
                int skip1=0;
                int skip2 = 0;

                if(s.charAt(i-1) == s2.charAt(j-1)){
                    take = 1+dp[i-1][j-1];;
                }else{
                    skip1=dp[i-1][j];
                    skip2=dp[i][j-1];
                }

                dp[i][j] = take+Math.max(skip1, skip2);
            }
        }

        return dp[n][n];
    }

    static int helper(String s1, String s2, int idx1, int idx2){
        if(idx1<0 || idx2<0) return 0;
        
        int take = 0;
        int skip1=0;
        int skip2 = 0;
        if(s1.charAt(idx1) == s2.charAt(idx2)){
          take = 1+helper(s1, s2, idx1-1, idx2-1);
        }else{
            skip1 = helper(s1, s2, idx1-1, idx2);
            skip2 = helper(s1, s2, idx1, idx2-1);
        }

        

        return take+(Math.max(skip1, skip2));
    }
}