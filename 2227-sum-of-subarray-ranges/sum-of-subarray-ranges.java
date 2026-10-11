class Solution {

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<int[]> st = new Stack<>();
        long[] res = new long[nums.length];

        // Find the sum of all the minimum.
        long minSum = 0;
        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek()[0]>=nums[i]){
                st.pop();
            }
            int j = st.isEmpty()?-1:st.peek()[1];
            res[i] = (st.isEmpty()?(long)nums[i]*(i+1):res[j]+ (long)nums[i]*(i-j));
            minSum+=res[i];
            st.push(new int[]{nums[i], i});
        }

        // Find the sum of all the maximum.
        st.clear();
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek()[0]<=nums[i]){
                st.pop();
            }
            int j = st.isEmpty()?-1:st.peek()[1];
            res[i] = (st.isEmpty()?(long)nums[i]*(i+1):res[j]+ (long)nums[i]*(i-j));
            maxSum+=res[i];
            st.push(new int[]{nums[i], i});
        }
        return maxSum-minSum;
    }
}