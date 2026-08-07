class Solution {
    int[] dp;
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        dp = new int[n];
        Arrays.fill(dp, -1) ;
        return helper(nums, n, 0);
    }

    int helper(int[] nums, int n , int idx){
        if(idx>=n){
            return Integer.MAX_VALUE/2;
        }
        if(idx == n-1) return 0;
        if(dp[idx] != -1) return dp[idx];
        int limit = nums[idx];
        int count = Integer.MAX_VALUE/2;
        for(int i=1;i<=limit;i++){
          count = Math.min(count, 1+helper(nums, n, idx+i));
        }

        return dp[idx] = count;
    }
}