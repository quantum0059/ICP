class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];

        for(int i=0;i<n;i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
         Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(jobs, 0, dp);
    }

    int helper(int[][] jobs, int idx, int[] dp){
        if(idx>=jobs.length){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int skip = helper(jobs, idx+1, dp);

        int findNextJob = find(jobs, jobs[idx][1]);
        int take = jobs[idx][2]+helper(jobs, findNextJob, dp);

        return dp[idx] = Math.max(take, skip);
    }

    int find(int[][] jobs, int endTime){
        int l = 0;
       int r=jobs.length-1;
        int ans = jobs.length;

        while(l<=r){
            int mid = l+(r-l)/2;

            if(jobs[mid][0]>=endTime){
                r=mid-1;
                ans = mid;
            }else{
                l=mid+1;
            }
        }

        return ans;
    }
}