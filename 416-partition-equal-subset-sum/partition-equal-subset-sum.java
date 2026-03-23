class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = (Arrays.stream(nums).sum());

        Boolean[][] dp = new Boolean[n][(sum/2)+1];

        if(sum%2 != 0) return false;


        return helper(nums, n-1, sum/2, dp);


    }
    static boolean helper(int[] nums, int idx, int sum, Boolean[][] dp){
        if(sum == 0) return true;
        if(idx<0){
            return false;
        }
        if(dp[idx][sum] != null) return dp[idx][sum];
        boolean take = false;
        if(sum>=nums[idx]){
            take = helper(nums, idx-1, sum-nums[idx], dp);
        }
        boolean notTake = helper(nums, idx-1, sum, dp);
        

        return dp[idx][sum] = (notTake || take);
    }
}