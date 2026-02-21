class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum =0;
        for(int i: nums){
            totalSum+=i;
        }

        if(Math.abs(target) > totalSum) return 0;
        if((target+totalSum)%2 != 0) return 0;
        //p-n = target;
        //p+n = totalSum;
        int p = (totalSum+target)/2;


        return helper(nums,0, p);
    }
    static int helper(int[] nums,  int idx , int rem){
        if(idx == nums.length) return rem==0?1:0;

        int stillValid = helper(nums, idx+1, rem);
        if(nums[idx]<=rem){
            stillValid += helper(nums, idx+1, rem-nums[idx]);
        }

        return  stillValid;
    } 
}