class Solution {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int num: nums){
            for(int sum=target;sum>=num;sum--){
                dp[sum] += dp[sum-num];
            }
        }

        return dp[target]==0? false:true;
    }
}