class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count = 0;
        for(int l=0;l<nums.length;l++){
            int targetCount = 0;
            for(int r=l;r<nums.length;r++){
                if(nums[r] == target){
                    targetCount++;
                }

                int size = r-l+1;
                if(targetCount > (size/2)){
                    count++;
                }
            }
        }
        return count;
    }
}