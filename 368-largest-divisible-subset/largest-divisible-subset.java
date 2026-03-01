class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
       int[] dp = new int[n];
       Arrays.fill(dp, 1);
       int[] hash = new int[n];
       int max = Integer.MIN_VALUE;
       int lastIdx = 0;
       for(int i=1;i<n;i++){
            hash[i] = i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    hash[i]=j;
                }
            }
            if(dp[i]>max){
                max= dp[i];
                lastIdx = i;
            }
       }

       List<Integer> list = new ArrayList<>();
       list.add(nums[lastIdx]);

       while(hash[lastIdx] != lastIdx){
        lastIdx = hash[lastIdx];
        list.add(nums[lastIdx]);
       }

       Collections.reverse(list);
       return list;


        
    }
}