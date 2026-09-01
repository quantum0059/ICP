class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
       
        int[] dp = new int[n];
        int[] cached = new int[n];
        int lastIdx = 0;
          Arrays.fill(cached, -1);

        int max = 1;
        Arrays.fill(dp, 1);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]< 1+dp[j]){
                    dp[i] = 1+dp[j];
                    cached[i] = j;
                }
            }
            if(dp[i]>max){
                max = dp[i];
                lastIdx = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (lastIdx != -1) {
            list.add(0, nums[lastIdx]);
            lastIdx = cached[lastIdx];
        }
        System.out.print(list.toString());

        return max;
    }

}