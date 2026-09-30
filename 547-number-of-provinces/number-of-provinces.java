class Solution {
    ArrayList<ArrayList<Integer>> makeAdjList(int[][] arr){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = arr.length;
        int m = arr[0].length;
        
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i!=j && arr[i][j] == 1){
                     list.get(i).add(j);
                }
            }
        }
        return list;
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> list = makeAdjList(isConnected);

        boolean[] vis = new boolean[isConnected.length];
        
        int count = 0;
        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
               count++;
               DFS(list, vis, i);
            }
        }

        return count;

    }
    void DFS(ArrayList<ArrayList<Integer>> list, boolean[] vis, int idx){
          vis[idx] = true;

          for(int i: list.get(idx)){
            if(!vis[i]){
                DFS(list, vis, i);
            }
          }
    }
}