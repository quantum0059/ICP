class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j]){
                    dp1[i] = Math.max(dp1[i], dp1[j]+1);
                }
            }
        }
        
        int output = 0;
        for(int i=0;i<n;i++){
            if(dp[i]>1 && dp1[i]>1){
                output = Math.max(output, dp[i]+dp1[i]-1);
            }
        }
        
        return output == n?0:n-output;
    }
}