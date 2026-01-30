class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;

        int[] dp = new int[n];

        Deque<Integer> q = new ArrayDeque<>();
        dp[0] = nums[0];
        q.addFirst(0);

        for(int i=1;i<n;i++){

            while(q.peekFirst()<i-k){
                q.pollFirst();
            }

            dp[i] = nums[i] + dp[q.peekFirst()];

            while(!q.isEmpty() && dp[q.peekLast()] <= dp[i]){
                q.pollLast();
            }

            q.addLast(i);
        }

        return dp[n-1];
    }
}