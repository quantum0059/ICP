class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
          int[] arr = new int[n+2];
          arr[0] = 1;
          arr[n+1] = 1;
          for(int i=0;i<n;i++){
            arr[i+1] = nums[i];
          }

          int[][] dp = new int [n+2][n+2];

          for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;

                int maxCoins = 0;
                for(int k=i;k<=j;k++){
                    int coins = arr[i-1]*arr[k]*arr[j+1]+dp[i][k-1] + dp[k+1][j];
                    maxCoins = Math.max(maxCoins, coins);
                }
                dp[i][j] = maxCoins;
            }
          }
        return dp[1][n];
    }
    static int helper(int i, int j, int[] nums){
        if(i>j){
            return 0;
        }
        int maxCoins = Integer.MIN_VALUE;

        for(int k=i;k<=j;k++){

            int coins = nums[i-1]*nums[k]*nums[j+1] + helper(i, k-1, nums)+helper(k+1, j, nums);
            maxCoins = Math.max(maxCoins, coins);
        }

        return maxCoins;
    }
}