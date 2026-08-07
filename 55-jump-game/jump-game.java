class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new Boolean[n]; 
        return helper(nums, n, 0);
    }

    boolean helper(int[] nums, int n , int idx){
        if(idx>=n){
            return false;
        }
        if(idx == n-1) return true;
        if(dp[idx] != null) return dp[idx];
        int limit = nums[idx];
        
        for(int i=1;i<=limit;i++){
          if(helper(nums, n, idx+i)){
            return dp[idx] = true;
          }
        }

        return dp[idx] = false;
    }
}