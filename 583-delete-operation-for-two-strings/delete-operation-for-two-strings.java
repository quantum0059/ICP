class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp= new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int take =0;
                int skip1 = 0;
                int skip2=0;

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    take = 1+dp[i-1][j-1];
                }else{
                    skip1 = dp[i-1][j];
                    skip2 = dp[i][j-1];
                }

                dp[i][j] = take+Math.max(skip1, skip2);
            }
        }

        int res = (n+m)-2*(dp[n][m]);
        return res;
    }
}