class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k-1);
    }

    static int atmost(int[] nums, int k){
        int count =0;
        int l=0;
        int ele = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!= 0) ele++;
            while(l<nums.length && ele>k){
                int e = nums[l];
                if(e%2!= 0) ele--;
                l++;
            }

            count+=(i-l+1);
        }

        return count;
    }
}