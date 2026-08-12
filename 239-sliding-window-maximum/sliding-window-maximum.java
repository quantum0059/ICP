class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;

        for (int right = 0; right < n; right++) {

            
            while (!dq.isEmpty() && dq.peekFirst() <= right - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] < nums[right]) {
                dq.removeLast();
            }

            dq.addLast(right);

            if (right >= k - 1) {
                ans[idx++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}