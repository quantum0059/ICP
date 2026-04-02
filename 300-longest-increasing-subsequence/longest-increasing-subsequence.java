class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]< 1+dp[j]){
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
        
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