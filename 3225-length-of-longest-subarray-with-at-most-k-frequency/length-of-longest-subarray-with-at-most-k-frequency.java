class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        while(right<nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);

            while(map.get(nums[right])>k){
                map.put(nums[left], map.get(nums[left])-1);
                left++;
            }

            max = Math.max(max, right-left+1);
            right++;
        }

        return max;
    }
}