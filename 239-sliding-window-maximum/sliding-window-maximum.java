class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] arr = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.removeLast();
            }

            dq.addLast(i);

            if(i>=k-1){
                 arr[idx++] = nums[dq.peekFirst()];
            }
        }

        return arr;
    }
}