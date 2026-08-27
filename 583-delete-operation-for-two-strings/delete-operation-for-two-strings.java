class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
       dp = new int[word1.length()][word2.length()];
       for(int[] arr: dp){
        Arrays.fill(arr, -1);
       }
       return helper(word1, word2, 0, 0);       
    }

    int helper(String word1, String word2, int idx1, int idx2){
        if(idx1>=word1.length()){
              return word2.length()-idx2;
        }
        if(idx2>=word2.length()){
              return word1.length()-idx1;       
        }

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(word1.charAt(idx1) == word2.charAt(idx2)){
            return dp[idx1][idx2]=helper(word1, word2, idx1+1, idx2+1);
        }

        return dp[idx1][idx2]=1+Math.min(helper(word1, word2, idx1+1, idx2), helper(word1, word2, idx1, idx2+1));

    }
}
