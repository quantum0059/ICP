class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k)-atMost(nums, k-1);
    }

    int atMost(int[] nums, int k){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int r=0;
        int l=0;
        int count = 0;

        while(r<n){

            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);

           while(map.size() > k){
             map.put(nums[l], map.get(nums[l])-1);

             if(map.get(nums[l]) == 0){
                map.remove(nums[l]);
             }

             l++;
           }

           count+=(r-l+1);
           r++;
        }

        return count;
    }
}