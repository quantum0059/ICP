class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    cnt[i] = cnt[j];
                }else if(dp[i] == dp[j]+1){
                    cnt[i]+=cnt[j];
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();
        int count =0;

        for(int i=0;i<nums.length;i++){
            if(dp[i] == max){
                count+=cnt[i];
            }
        }

        return count;
    }
}