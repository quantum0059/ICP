class Solution {
    public int minOperations(int[] nums) {
        int steps = 0;
        int firstZeroIdx = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                firstZeroIdx = i;
                break;
            }
        }

        if(firstZeroIdx == -1)return 0;

       

        for(int i = firstZeroIdx; i<=nums.length-3;i++){
              if(nums[i] == 0){
                for(int j=i;j<i+3;j++){
                    if(nums[j] == 0){
                        nums[j] = 1;
                        
                    }else{
                        nums[j] = 0;
                    }
                }
                steps++;
               }       
        }

        for(int num: nums){
            if(num == 0){
                return -1;
            }
        }

        return steps;


    }
}