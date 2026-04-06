class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(n);
        for(int i: cuts){
            list.add(i);
        }
        Collections.sort(list);
        int[][] dp = new int[c+2][c+2];

        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;
                int min = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cost = list.get(j+1)-list.get(i-1)+dp[i][k-1]+dp[k+1][j];
                    min = Math.min(cost, min);
                }
                dp[i][j] = min;
            }
        }
        


        return dp[1][cuts.length];
    }
    static int helper(int i, int j, ArrayList<Integer> list, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost = list.get(j+1)-list.get(i-1)+helper(i, k-1, list, dp)+helper(k+1, j,list, dp);
            min = Math.min(cost, min);
        }
        
        return dp[i][j] = min;

    }
}