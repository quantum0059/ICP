class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int diff = 0;
        for(int i=0;i<nums.length;i++){
            int res = 0;
            int ele = nums[i];
            while(ele>0){
                res+=ele%10;
                ele/=10;
            }
            diff+=res;
        }

        return Math.abs(sum-diff);
    }
}