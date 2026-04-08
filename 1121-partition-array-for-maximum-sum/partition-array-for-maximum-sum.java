class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        
        for(int i=n-1;i>=0;i--){
             int maxSum = Integer.MIN_VALUE;
             int len = 0;
             int max = Integer.MIN_VALUE;

             for(int j=i;j<Math.min(i+k, n);j++){
                len++;
                max = Math.max(max, arr[j]);
                int sum = (max*len)+helper(j+1, n, arr, k, dp);
                maxSum = Math.max(maxSum, sum);
            }
            dp[i] = maxSum;
        }
        return dp[0];
    }

    static int helper(int i, int n, int[] arr, int k, int[] dp){
        if(i>=n) return 0;

        if(dp[i] != -1) return dp[i];

        int maxSum = Integer.MIN_VALUE;
        int len = 0;
        int max = Integer.MIN_VALUE;
        for(int j=i;j<Math.min(i+k, n);j++){
            len++;
            max = Math.max(max, arr[j]);
            int sum = (max*len)+helper(j+1, n, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }

        return dp[i] = maxSum;
    }
}