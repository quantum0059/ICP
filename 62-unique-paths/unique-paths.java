class Solution {
    public int uniquePaths(int m, int n) {
       int[][] isVis = new int[m][n];
       int[][] dp = new int[m][n];
       dp[m-1][n-1] = 1;

       for(int i=m-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            if(i==m-1 && j==n-1) continue;
            
            int[] dr = {0, 1};
            int[] dc = {1, 0};

            int count =0;

            for(int k=0;k<2;k++){
                int ni = i + dr[k];
                int nj = j + dc[k];

                if(ni < m && nj < n){  
                    count += dp[ni][nj];
                }
            }

             dp[i][j] = count;

        }
       }

       return dp[0][0];

    }
    static int helper(int r ,int c, int sr, int sc, int[][] isVis, int[][] dp){
        if(sr == r-1 && sc == c-1){
            return 1;
        }
        if(sr<0 || sc<0 || sr>=r || sc>=c || isVis[sr][sc] == 1){
            return 0;
        }

        if(dp[sr][sc] != -1) return dp[sr][sc];

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        isVis[sr][sc] = 1;
        int count =0;

        for(int i=0;i<2;i++){
                count += helper(r, c, sr+dr[i], sc+dc[i], isVis, dp);
        }
        isVis[sr][sc] = 0;
        return dp[sr][sc] = count;
    }
}