class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = (Arrays.stream(nums).sum());
        if(sum%2 != 0) return false;

        boolean[][] dp = new boolean[n+1][(sum/2)+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }

        for(int idx=1;idx<=n;idx++){
            for(int s=1;s<=(sum/2);s++){
                boolean notTake = dp[idx-1][s];
                boolean take = false;
                if(s>=nums[idx-1]){
                    take = dp[idx-1][s-nums[idx-1]];
                }
                

                dp[idx][s] = (take||notTake);
            }
        }

        return dp[n][sum/2];
    }
}