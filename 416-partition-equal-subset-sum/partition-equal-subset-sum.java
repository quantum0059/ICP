class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n==1){
            return false;
        }

        int totalSum = 0;
        for(int i: nums){
            totalSum+=i;
        }
        Boolean dp[][] = new Boolean[n][totalSum];

        return isPossible(nums, totalSum, 0, 0, dp);
    }

    static boolean isPossible(int[] nums, int totalSum, int idx, int sum, Boolean[][] dp){
        if(idx == nums.length){
            return false;
        }

        if(sum == (totalSum-sum)){
            return true;
        }

        if(sum>(totalSum-sum)){
            return false;
        }
        if(dp[idx][sum] != null){
            return dp[idx][sum];
        }

        return dp[idx][sum] = isPossible(nums, totalSum, idx+1, sum+nums[idx], dp)|| isPossible(nums, totalSum, idx+1, sum, dp); 
    }
}