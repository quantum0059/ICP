class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int min = Integer.MAX_VALUE;
        dp = new int[n][n];
        for(int[] arr: dp){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for(int i=0;i<m;i++){
            min = Math.min(min, helper(matrix,0, i));
        }

        return min;
    }

    int helper(int[][] matrix,int r, int c){
         if (c < 0 || c >= matrix.length)
        return Integer.MAX_VALUE;


        if (r == matrix.length-1)
        return dp[r][c] = matrix[r][c];

        if(dp[r][c] != Integer.MAX_VALUE){
            return dp[r][c];
        }
        
        int below = helper(matrix,r+1, c);
        int leftD = helper(matrix,r+1, c-1);
        int rightD = helper(matrix,r+1, c+1);

        return dp[r][c] = matrix[r][c]+Math.min(below, Math.min(leftD, rightD));
    }
}