class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIdx = 0, minEle = nums[0];
        int maxIdx = 0, maxEle = nums[0];

        for(int i=0;i<n;i++){
            if(nums[i]<minEle){
                minEle = nums[i];
                minIdx = i;
            }

            if(nums[i]>maxEle){
                maxEle = nums[i];
                maxIdx = i;
            }

        }
        int res1 = Math.max(maxIdx+1, minIdx+1);
        int res2 = Math.max(n-minIdx, n-maxIdx);
        int res = Math.min(res1, res2);
        int minDis = Math.min(minIdx+1, n-minIdx);
        int maxDis = Math.min(maxIdx+1, n-maxIdx);
        int res3 = minDis+maxDis;

        return Math.min(res3, res);
    }
}