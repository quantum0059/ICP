class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length, m = costs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(days, costs, dp, 0);
    }

    int helper(int[] days, int[] costs, int[] dp, int idx){
        if(idx>=days.length){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int minCost = Integer.MAX_VALUE;
        for(int i=0;i<costs.length;i++){
           int duration;

            if (i == 0) {
                duration = 1;
            } else if (i == 1) {
                duration = 7;
            } else {
                duration = 30;
            }
            int currDays = days[idx]+duration;
            int currIdx = idx;

            while(currIdx<days.length && days[currIdx]<currDays){
                currIdx++;
            }

           minCost = Math.min(minCost, costs[i]+helper(days, costs, dp, currIdx));
        }

        return dp[idx] = minCost;
        
    }
}