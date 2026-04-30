class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k+1];
        for(int[][] arr: dp){
            for(int[] a: arr){
                Arrays.fill(a, -2);
            }
        }

        return score(grid, k, 0, 0, n, m, dp);
    }

    static int score(int[][] grid, int valid, int i, int j, int row, int col, int[][][] dp){
          if(i>=row || j>=col) return -1;

          int cost = (grid[i][j] == 0) ? 0:1;

           if(cost>valid) return -1; 

           if(i==row-1 && j==col-1) return grid[i][j];

           if(dp[i][j][valid] != -2) return dp[i][j][valid];


           int right = score(grid, valid-cost, i-0, j+1, row, col, dp);
           int down = score(grid, valid-cost, i+1, j-0, row, col, dp);

           int best = Math.max(right, down);
           if(best == -1) return dp[i][j][valid] = -1;

          return dp[i][j][valid] = grid[i][j]+best;
    }
}