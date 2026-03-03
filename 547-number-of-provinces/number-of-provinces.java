class Solution {
    static ArrayList<ArrayList<Integer>> convertToAdj(int[][] isConnected){
           int n = isConnected.length;
           ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
       for (int i = 0; i < n; i++) {
          adj.add(new ArrayList<>());  // initialize list for each node
      }
    
       for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
             if (i != j && isConnected[i][j] == 1) {
                  adj.get(i).add(j);
             }
          }
      } 
    
       return adj;
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = convertToAdj(isConnected);

        boolean isVis[] = new boolean[adj.size()];
        int count = 0;
        for(int i=0;i<isConnected.length;i++){
            if(!isVis[i]){
                count++;
                Dfs(adj, i, isVis);
            }
        }
        return count;
    }
    static void Dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] isVis){
        isVis[node] = true;

        for(Integer i: adj.get(node)){
            if(!isVis[i]){
                Dfs(adj, i, isVis);
            }
        }

        return;
    }
}