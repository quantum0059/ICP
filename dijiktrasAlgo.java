class Solution {
    static class Pair{
        int weight;
        int node;
        Pair(int weight, int node){
            this.weight = weight;
            this.node = node;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];
            
            graph.get(a).add(new Pair(c, b));
            graph.get(b).add(new Pair(c, a));
        }
        
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)-> a.weight-b.weight);
        q.offer(new Pair(0, src));
        dis[src] = 0;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            int d = p.weight;
            int node = p.node;
            
             if (d > dis[node]) continue;
            
            for(Pair ele: graph.get(node)){
                int w = ele.weight;
                int n = ele.node;
                
                if(d+w < dis[n]){
                    dis[n] = d+w;
                    q.offer(new Pair(dis[n], n));
                }
            }
            
        }
        return dis;
    }
}
