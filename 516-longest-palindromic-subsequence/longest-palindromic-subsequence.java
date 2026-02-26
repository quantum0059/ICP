class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return helper(s1, s2, 0, 0, dp);
    }

    static int helper(String s1, String s2, int i, int j, int[][] dp){
        if(i==s1.length() || j==s2.length()) return 0;

         if(dp[i][j] != -1){
            return dp[i][j];
         }
        
        if(s1.charAt(i) == s2.charAt(j)){
           return dp[i][j] = 1+helper(s1, s2, i+1, j+1, dp);
        }

        int skip1 = helper(s1, s2, i+1, j, dp);
        int skip2 = helper(s1, s2, i, j+1, dp);

        return dp[i][j] = Math.max(skip1, skip2);
    }
}