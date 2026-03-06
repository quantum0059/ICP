class Solution {
    public boolean isMatch(String s, String p) {
        
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];

        return helper(s, p, 0, 0, dp);
    }

    static boolean helper(String s, String p, int idx1, int idx2, Boolean[][] dp){
       
        if(idx2>=p.length()){
            return idx1>=s.length();
        } 

        if(dp[idx1][idx2] != null) return dp[idx1][idx2];

        boolean match = (idx1<s.length()) && (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '.');

        if(idx2+1<p.length() && p.charAt(idx2+1)=='*'){
           return dp[idx1][idx2] = (helper(s, p, idx1, idx2+2, dp) || (match && helper(s, p, idx1+1, idx2, dp)));
        }

        if(match){
            return dp[idx1][idx2] = helper(s, p, idx1+1, idx2+1, dp);
        }

        return dp[idx1][idx2] = false;
    }
}