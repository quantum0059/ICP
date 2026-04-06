class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> list = new ArrayList<>();
        // Arrays.sort(cuts);
        list.add(0);
        list.add(n);
        // list.addAll(Arrays.asList(cuts));
        for(int i: cuts){
            list.add(i);
        }
        Collections.sort(list);
        int[][] dp = new int[list.size()][list.size()];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }


        return helper(1, cuts.length, list, dp);
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