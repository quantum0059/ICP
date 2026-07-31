class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) return -1;

        int[][] dp = new int[n][d];

        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return findMin(jobDifficulty, n, 0, d, dp);
        
    }

    int findMin(int[] arr, int size, int idx, int d, int[][] dp){
        if(d == 1){
            int max = arr[idx];

            for(int i=idx;i<size;i++){
                max = Math.max(max, arr[i]);
            }

            return dp[idx][d-1]=max;
        }

        if(dp[idx][d-1] != -1){
            return dp[idx][d-1];
        }

        int finalMin = Integer.MAX_VALUE;

        int max = arr[idx];
        int result = 0;

        for(int i=idx;i<=size-d;i++){
            max = Math.max(max, arr[i]);

            result = max+findMin(arr, size, i+1, d-1,dp);

            finalMin = Math.min(finalMin, result);
        }

        return dp[idx][d-1] = finalMin;
    }
}


// int[][] dp = new int[d+1][n+1];

//         dp[0][n] = 0;

//         int finalMin = Integer.MAX_VALUE;

//         for(int i=1;i<=d;i++){
//             int max = Integer.MIN_VALUE;
//             for(int j=n;j>=0;j--){
//                 max = Math.max()
//             }
//         }