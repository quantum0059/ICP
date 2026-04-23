class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();

        long[] res = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                int f = freq.get(nums[i]);
                long s = sum.get(nums[i]);

                res[i] += (long) i * f - s;

                freq.put(nums[i], f + 1);
                sum.put(nums[i], s + i);
            } else {
                freq.put(nums[i], 1);
                sum.put(nums[i], (long) i);
            }
        }

        freq.clear();
        sum.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (freq.containsKey(nums[i])) {
                int f = freq.get(nums[i]);
                long s = sum.get(nums[i]);

                res[i] += s - (long) i * f;

                freq.put(nums[i], f + 1);
                sum.put(nums[i], s + i);
            } else {
                freq.put(nums[i], 1);
                sum.put(nums[i], (long) i);
            }
        }

        return res;
    }
}