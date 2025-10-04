class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }

        int[] sum = new int[n];

        sum[0] = nums[0];

        sum[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++){
            sum[i] = Math.max(nums[i]+sum[i-2], sum[i-1]);
        }

        return sum[n-1];
    }
}
