class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ele = nums[(nums.length-1)/2];
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != ele){
                if(nums[i]<ele){
                    count+=(ele-nums[i]);
                }else{
                    count+=(nums[i]-ele);
                }
            }
        }

        return count;
    }
}