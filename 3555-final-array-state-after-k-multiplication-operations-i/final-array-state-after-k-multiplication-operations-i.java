class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i=0;i<k;i++){
            int minIdx = 0;
            int min = nums[0];
            for(int j=1;j<nums.length;j++){
               if(min>nums[j]){
                minIdx = j;
                min = nums[j];
               }
            }
            nums[minIdx]*=multiplier;
        }

        return nums;
    }
}