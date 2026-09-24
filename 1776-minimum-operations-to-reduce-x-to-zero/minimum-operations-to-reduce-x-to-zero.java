class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0,-1);

        int n = nums.length;

        int sum =0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            map.putIfAbsent(sum, i);
        }

        int remainingSum = sum-x;
         if (remainingSum < 0) return -1;
        if (remainingSum == 0) return n;

        int maxLength = -1;
        sum=0;
        for(int i=0;i<n;i++){
           sum+=nums[i];

           if(map.containsKey(sum-remainingSum)){
            maxLength = Math.max(maxLength, i-map.get(sum-remainingSum));
           }
        }

        return maxLength == -1  ? -1: nums.length-maxLength;
    }
}