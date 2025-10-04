package Day7;

import java.util.Arrays;

public class UniquePaths {
    class Solution {
    int[][]dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,0,m,n);
    }
    public int helper(int i , int j , int m , int n){
        if(i>= m || j>=n){
            return 0;
        }
        if(i == m-1 && j== n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down = helper(i+1,j,m,n);
        int right = helper(i,j+1,m,n);
        dp[i][j] = down + right;
        return dp[i][j];
    }
}
}
