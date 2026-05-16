class Solution {
    public int longestOnes(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);

        int st = 0;
        int maxLength  = 0;

        for(int i=0;i<nums.length;i++){
           int ele  = nums[i];

           while(st<nums.length && ele == 0 && map.get(0)==k){
            int e = nums[st];
            map.put(e, map.get(e)-1);
            st++;
           }

           map.put(ele, map.get(ele)+1);
           maxLength  = Math.max(maxLength, i-st+1);

        }

        return maxLength;
    }
}