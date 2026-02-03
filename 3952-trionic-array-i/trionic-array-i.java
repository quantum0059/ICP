class Solution {
    public boolean isTrionic(int[] nums) {
        
        boolean incresing = false;
        boolean decresing = false;

        if(nums[1]<=nums[0]) return false;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]) return false;
          
          if(!incresing && !decresing){
            if(nums[i] <nums[i-1]){
                  incresing = true;
            }
          }else if(incresing && !decresing){
            if(nums[i]>nums[i-1]){
                decresing = true;
            }
          }else {
            if(nums[i]<nums[i-1]){
                return false;
            }
          }
        }

        return incresing && decresing;
    }
}