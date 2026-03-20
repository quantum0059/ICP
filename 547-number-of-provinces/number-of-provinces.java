class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = isConnected.length;
        int m = isConnected[0].length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
            if(i!=j && isConnected[i][j] == 1){
                adj.get(i).add(j);
            }
          }
        }

        boolean[] isVis = new boolean[n];
        int count = 0;

        for(int i=0;i<n;i++){
            if(!isVis[i]){
                dfs(i, isVis, adj);
                count++;
            }
        }
        return count;
    }
    static void dfs(int node, boolean[] isVis, ArrayList<ArrayList<Integer>> adj){
        isVis[node] = true;

        for(int i: adj.get(node)){
            if(!isVis[i]){
                dfs(i, isVis, adj);
            }
        }

        return;
    }
}