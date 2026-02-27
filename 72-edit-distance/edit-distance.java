class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for(int[] arr: dp){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        return helper(word1, word2, n-1, m-1, dp);
    }

    static int helper(String word1,String word2, int i, int j, int[][] dp){
        if(i<0) return j+1;//you will j+1 inserttion oprn to make str1 == str2
        if(j<0) return i+1;//if str2==0 you have to delete every other char from str1 which req i+1 opr
         if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
         }
        if(word1.charAt(i) == word2.charAt(j)) return dp[i][j] = helper(word1, word2, i-1, j-1, dp);

        int insertion = 1+helper(word1, word2, i, j-1, dp);
        int deletion = 1+helper(word1, word2, i-1, j, dp);
        int replace = 1+helper(word1, word2, i-1, j-1, dp);

        return dp[i][j] = Math.min(insertion, Math.min(deletion, replace));
    }
}