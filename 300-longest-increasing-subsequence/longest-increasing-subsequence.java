class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int count =0;
                if(j==-1 || nums[j]<nums[i]){
                    count = 1+dp[i+1][i+1];
                }
                int skip = dp[i+1][j+1];

                dp[i][j+1] = Math.max(count, skip);
            }
        }
        
        
        return dp[0][0];
        
    }

    static int helper(int[] nums, int curr, int prev, int[][] dp){
        if(curr >= nums.length) return 0;
        if(prev != -1 && dp[curr][prev]!=-1) return dp[curr][prev];
        int count = 0;
        if(prev == -1 || nums[prev] < nums[curr]){
            count = 1+helper(nums, curr+1, curr, dp);
        }

        int skip = helper(nums, curr+1, prev, dp);

        return prev!= -1?dp[curr][prev]=Math.max(count, skip): Math.max(count, skip);
    }
}