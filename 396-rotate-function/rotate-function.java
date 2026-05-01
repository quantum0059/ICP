class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int prev = 0;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            prev+=(i*nums[i]);
            sum+=nums[i];
        }

        list.add(prev);
        for(int i=1;i<n;i++){
          list.add(prev+sum-(n*nums[n-1-(i-1)]));
          prev = list.get(list.size()-1);
        }

        return Collections.max(list);
    }
}