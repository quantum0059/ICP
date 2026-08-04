class Solution {
    Integer[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int min = Integer.MAX_VALUE;
        dp = new Integer[n][n];

        for(int i=0;i<m;i++){
            min = Math.min(min, helper(matrix,0, i));
        }

        return min;
    }

    int helper(int[][] matrix,int r, int c){
         if (c < 0 || c >= matrix.length)
        return 1_000_000_000;


        if (r == matrix.length-1)
        return dp[r][c] = matrix[r][c];

        if(dp[r][c] != null){
            return dp[r][c];
        }
        
        int below = helper(matrix,r+1, c);
        int leftD = helper(matrix,r+1, c-1);
        int rightD = helper(matrix,r+1, c+1);

        return dp[r][c] = matrix[r][c]+Math.min(below, Math.min(leftD, rightD));
    }
}