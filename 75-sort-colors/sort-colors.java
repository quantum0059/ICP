class Solution {
    public void sortColors(int[] nums) {
        int st = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                int temp = nums[st];
                nums[st] = 0;
                nums[i] = temp; 
                st++;
            }
        }
        st = nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] == 2){
                int temp = nums[st];
                nums[st] = nums[i];
                nums[i] = temp;
                st--;
            }
        }
    }
}