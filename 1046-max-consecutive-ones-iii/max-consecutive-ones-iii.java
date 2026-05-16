class Solution {
    public int longestOnes(int[] nums, int k) {
        int st = 0;
        int maxLength  = 0;
        int zeroes = 0;

        for(int i=0;i<nums.length;i++){
           int ele  = nums[i];

           if(ele == 0) {
            zeroes++;
           }

           while(zeroes > k){
             if(nums[st] == 0){
                zeroes--;
             }
             st++;
           }

            maxLength = Math.max(maxLength, i - st + 1);

        }

        return maxLength;
    }
}