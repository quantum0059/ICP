class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();

        int[] vis = new int[graph.length];
        int[] check = new int[vis.length];

        for(int i=0;i<graph.length;i++){
            if(vis[i]==0){
                dfs(graph, vis, check, i);
            }
        }

        for(int i=0;i<check.length;i++){
            if(check[i]==0){
                list.add(i);
            }
        }

        return list;
    }
    public boolean dfs(int[][] graph, int[] vis, int[] check, int node){
        vis[node] = 1;
        check[node] = 1;

        for(int i: graph[node]){
            if(vis[i]==0){
                if(dfs(graph, vis, check, i)) return true;
            }
            else if(check[i]==1) return true;
        }

        check[node] = 0;
        return false;
    }
}