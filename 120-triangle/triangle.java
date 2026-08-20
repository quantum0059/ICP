class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        dp[0][0] = triangle.get(0).get(0);

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(i==0 && j==0) continue;
                int up = Integer.MAX_VALUE;
                int diag = Integer.MAX_VALUE;
                if(j<i){
                    up = Math.min(up, dp[i-1][j]);
                }
                if(j>0){
                    diag = Math.min(diag, dp[i-1][j-1]);
                }

                dp[i][j] += triangle.get(i).get(j)+Math.min(up, diag);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }
}