class Solution {
    public int uniquePaths(int m, int n) {
       int[][] isVis = new int[m][n];
       int[][] dp = new int[m][n];
       for(int[] arr: dp){
        Arrays.fill(arr, -1);
       }
       return helper(m, n, 0, 0,isVis, dp); 
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