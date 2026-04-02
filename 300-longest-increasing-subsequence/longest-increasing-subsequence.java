class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        
        return helper(nums, 0, -1, dp);
        
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