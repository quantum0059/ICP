class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, k, 0, dp);
    }
    static int helper(int[] nums, int k, int idx, int[] dp){
        if(idx == nums.length) return 0;

        if(dp[idx] != -1){
            return dp[idx];
        }

        int count =0;
        int sum =0;
        for(int i=idx;i<nums.length;i++){
            sum+=nums[i];
            if(sum == k) count++;
        }

        return dp[idx]=count+helper(nums, k, idx+1, dp);

    }
}