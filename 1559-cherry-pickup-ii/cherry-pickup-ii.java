class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m][m];
        for(int[][] arr: dp){
            for(int[] a: arr){
                Arrays.fill(a, -1);
            }
        }
        return helper(grid, 0, 0, grid[0].length - 1);
    }

    int helper(int[][] grid, int r, int c1, int c2){
        int n = grid.length;
        int m = grid[0].length;
        if( c1<0 || r>=n || c1>=m  || c2<0 || c2>=m) return 0;
        if(r == n - 1){
            if(c1 == c2)
                return dp[r][c1][c2]=grid[r][c1];

            return dp[r][c1][c2]=grid[r][c1] + grid[r][c2];
        }
        if(dp[r][c1][c2]!=-1) return dp[r][c1][c2];
        int cherry = grid[r][c1];
        if(c1 != c2)
          cherry += grid[r][c2];

        int ans = 0;

        for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
                ans = Math.max(ans, helper(grid,r+1, c1+d1, c2+d2));
            }
        }


        return dp[r][c1][c2]=cherry+ans;

    }
}