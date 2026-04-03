class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    count[i] = count[j];
                }else if(dp[i] == dp[j]+1){
                    count[i]+=count[j];
                }
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();

        int cnt =0;
        for(int i=0;i<n;i++){
            if(dp[i] == max){
                cnt+=count[i];
            }
        }

        return cnt;
    }
}