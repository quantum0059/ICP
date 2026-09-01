class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
       return  helper(nums, 0, -1);
    }

    int helper(int[] nums, int idx, int prev){
        if(idx>=nums.length) return 0;

        if(prev != -1 && dp[idx][prev] != -1){
            return dp[idx][prev];
        }
        int take = 0;
        if(prev == -1 || nums[idx]> nums[prev]){
          take = 1+ helper(nums, idx+1, idx);
        } 

        int skip = helper(nums, idx+1, prev);

        if(prev != -1){
            dp[idx][prev] = Math.max(skip, take);
        }

        return Math.max(skip, take);
    }
}