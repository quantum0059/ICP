class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 if(i == 0 && j == 0) continue;
                int min = Integer.MAX_VALUE;
                if(i>0){
                    min = Math.min(min, dp[i-1][j]);
                }
                if(j>0){
                    min = Math.min(min, dp[i][j-1]);
                }

                dp[i][j] += grid[i][j]+min;

        }
        
    }
    return dp[n-1][m-1];

}
}