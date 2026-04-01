class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];

        for(int i=1;i<=n;i++){
            dp[i][0] = false;
        }
        dp[0][0] = true;
        for(int i=1;i<=m;i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
            }
            else{
                dp[0][i] = false;
            }
        }
        

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                boolean ans = false;
                if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){
                   ans  = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                   ans = (dp[i][j-1] || dp[i-1][j]);
                }

                dp[i][j] = ans;
            }
        }

        return dp[n][m];
    }

    static boolean helper(String s, String p, int idx1, int idx2, Boolean[][] dp){
       if(idx1<0 && idx2<0) return true;
       if(idx2<0) return false;
       if(idx1<0){
        for(int i = idx2;i>=0;i--){
            if(p.charAt(i) != '*') return false;
        }
        return true;
       }

       if(dp[idx1][idx2] != null){
          return dp[idx1][idx2] ;
       }
       boolean one = false;
       if(p.charAt(idx2) == '?' || p.charAt(idx2) == s.charAt(idx1)){
          one = helper(s, p, idx1-1, idx2-1, dp);
       }else if(p.charAt(idx2)== '*'){
          one = (helper(s, p, idx1, idx2-1, dp) || helper(s, p, idx1-1, idx2, dp));
       } 

       return dp[idx1][idx2] = one;

    }
}