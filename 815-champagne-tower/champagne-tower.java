class Solution {
    double[][] dp;
    public double champagneTower(int poured, int query_row, int query_glass) {
        dp = new double[query_row+1][query_row+1];
        for(double[] arr: dp){
            Arrays.fill(arr, -1.0);
        }
        return Math.min(1.0, helper(poured, query_row, query_glass));
    }
     double helper(int poured, int i, int j){
        if(i<0 || j<0 || i<j){
            return 0.0;
        }

        if(dp[i][j] != -1.0){
            return dp[i][j];
        }

        if(i==0 && j==0) return dp[i][j] = poured;

        
        double left_up = Math.max(0, (helper(poured, i - 1, j - 1) - 1) / 2);
        double right_up = Math.max(0, (helper(poured, i - 1, j) - 1) / 2);

        return dp[i][j] = left_up+right_up;
    }
}