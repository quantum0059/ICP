class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];

        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return helper(dp, text1, text2, n, m, 0, 0);
    }

    int helper(int[][] dp, String text1, String text2, int n, int m, int idx1, int idx2){
        if(idx1>=n || idx2>=m){
            return 0;
        }
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int take=0, skip1=0, skip2 = 0;
        
        if(text1.charAt(idx1) == text2.charAt(idx2)){
           take = 1+helper(dp, text1, text2, n, m, idx1+1, idx2+1);
        }else{
           skip1 = helper(dp, text1, text2, n, m, idx1+1, idx2);
           skip2 = helper(dp, text1, text2, n, m, idx1, idx2+1);
        }

        return dp[idx1][idx2] = Math.max(take, Math.max(skip1, skip2));
    }
}