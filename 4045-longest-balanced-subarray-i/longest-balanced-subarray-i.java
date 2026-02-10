class Solution {
    public int longestBalanced(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int maxLen = 0;

        for(int i=0;i<nums.length;i++){
            HashMap<Integer, Integer> odd = new HashMap<>();
            HashMap<Integer, Integer> even = new HashMap<>();

            for(int j=i;j<nums.length;j++){
                HashMap<Integer, Integer> map = (nums[j] & 1) == 1?odd:even;
                map.put(nums[j], map.getOrDefault(nums[j], 0)+1);

                if(even.size() == odd.size()){
                      maxLen  = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;

    }
}