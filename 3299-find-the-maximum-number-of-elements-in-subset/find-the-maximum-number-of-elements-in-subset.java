class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int oneCount = map.getOrDefault(1, 0);

        int ans = (oneCount & 1) == 1?oneCount:oneCount-1;

        map.remove(1);

        for(int i: nums){
            
          int count = 0;
          int val = i;

          while(map.containsKey(val) && map.get(val) > 1){
            count+=2;
            val*=val;
          }

          ans = Math.max(ans, count+ (map.containsKey(val) ? 1: -1));
            
        }
        return ans;
    }
}