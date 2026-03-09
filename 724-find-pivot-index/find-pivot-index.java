class Solution {
    public int pivotIndex(int[] arr) {
       int[] preSum = new int[arr.length];

        preSum[0] = arr[0];

        for(int i = 1; i < arr.length; i++) {
            preSum[i] = arr[i] + preSum[i-1];
        }

        int maxSum = preSum[arr.length - 1];
        int idx = -1;

        for(int i = 0; i < arr.length; i++) {
            int left = preSum[i]-arr[i];
            int right = maxSum-preSum[i];

            if(left == right){
                idx = i;
                break;
            }
        }

        return idx;
    }
}