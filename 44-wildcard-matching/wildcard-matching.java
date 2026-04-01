class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];

        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return helper(s, p, n-1, m-1, dp);
    }

    static boolean helper(String s, String p, int idx1, int idx2, int[][] dp){
       if(idx1<0 && idx2<0) return true;
       if(idx2<0) return false;
       if(idx1<0){
        for(int i = idx2;i>=0;i--){
            if(p.charAt(i) != '*') return false;
        }
        return true;
       }

       if(dp[idx1][idx2] != -1){
          return dp[idx1][idx2] == 1;
       }
       boolean one = false;
       if(p.charAt(idx2) == '?' || p.charAt(idx2) == s.charAt(idx1)){
          one = helper(s, p, idx1-1, idx2-1, dp);
       }else if(p.charAt(idx2)== '*'){
          one = (helper(s, p, idx1, idx2-1, dp) || helper(s, p, idx1-1, idx2, dp));
       } 

       dp[idx1][idx2] = one?1:0;

       return one;
    }
}