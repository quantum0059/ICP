class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] arr = new int[nums.length];
        int n = nums.length;

        for(int i=0;i<n;i++){
            int idx = (nums[i]+i)%n;
             if(idx<0){
                idx+=n;
            }
            arr[i] = nums[idx];
        }

        return arr;
    }
}