class Solution {
    int[][][] dp ;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        dp = new int[n][n][n];

        for(int[][] arr: dp){
            for(int[] a: arr){
                Arrays.fill(a, -1);
            }
        }
         return Math.max(0, helper(grid, 0, 0, 0));
    }

    int helper(int[][] grid,int r1, int c1, int r2){
        int n = grid.length;
        int c2 = r1+c1-r2;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n)
            return -1000000;

    
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return -1000000;

        if (r1 == n - 1 && c1 == n - 1)
            return dp[r1][c1][r2] = grid[r1][c1];

    
        if(dp[r1][c1][r2] != -1) return dp[r1][c1][r2];
        int cherry = grid[r1][c1];

        if (r1 != r2 || c1 != c2)
            cherry += grid[r2][c2];
        
        
        int ans = Math.max(
                Math.max(
                        helper(grid, r1 + 1, c1, r2 + 1), 
                        helper(grid, r1 + 1, c1, r2)      
                ),
                Math.max(
                        helper(grid, r1, c1 + 1, r2 + 1), 
                        helper(grid, r1, c1 + 1, r2)   
                )
        );

        
        if (ans < 0)
            return dp[r1][c1][r2]=-1000000;

        return dp[r1][c1][r2]=cherry + ans;
    }
}