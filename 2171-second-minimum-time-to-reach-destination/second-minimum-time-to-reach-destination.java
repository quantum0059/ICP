class Solution {
    static class Pair{
        int node;
        int time;
        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
    }
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        int INF = (int)1e8;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] arr: edges){
            int u = arr[0];
            int v = arr[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int dis[][] = new int[n+1][2];
        for(int[] arr: dis){
            Arrays.fill(arr, INF);
        }
        dis[1][0] = 0;
        

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->  Integer.compare(a.time, b.time));
        pq.add(new Pair(1, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int t = p.time;

            // if(dis[node]< t) continue;
            for(int i: graph.get(node)){
                int newTime = t;
                if((newTime/change)%2 == 1){
                    newTime = ((newTime/change)+1)*change;
                }
                newTime+=time;
                if(dis[i][0]>newTime){
                   dis[i][0] = newTime;
                   pq.add(new Pair(i, newTime));
                }
                if(newTime> dis[i][0] && newTime < dis[i][1]){
                    dis[i][1] = newTime;
                    pq.add(new Pair(i, newTime)); 
                }
            }
        }
        return dis[n][1];
    }
}