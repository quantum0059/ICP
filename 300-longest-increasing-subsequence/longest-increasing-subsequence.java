class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return helper(nums, 0, -1, dp);
    }

    static int helper(int[] nums, int idx, int prevIdx, int[][] dp){
        if(idx == nums.length) return 0;

        if( prevIdx != -1 && dp[idx][prevIdx] != -1) return dp[idx][prevIdx]; 

        int notTake = helper(nums, idx+1, prevIdx, dp);

        int take =0;
        if(prevIdx == -1 || nums[prevIdx]<nums[idx]){
            take=1+helper(nums, idx+1, idx, dp);
        }
        if(prevIdx == -1){
            return Math.max(take, notTake);
        }
        return dp[idx][prevIdx] = Math.max(take, notTake);
    }
}