class Solution {
    static class St{
        int des;
        int weight;
        St(int des, int weight){
            this.des = des;
            this.weight = weight;
        }
    }
    static class Pair{
        int node;
        int weight;
        int stop;
        Pair(int node, int weight, int stop){
            this.node = node;
            this.weight = weight;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<St>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            int a = flights[i][0];
            int b = flights[i][1];
            int c = flights[i][2];

            graph.get(a).add(new St(b, c));
        }

        int[] dest = new int[n];
        Arrays.fill(dest, (int)1e9);
        dest[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        //becuse we hv to take priority of the stops not weight that's why no priorityQueue;

        q.add(new Pair(src, 0, 0));


        while(!q.isEmpty()){
           Pair p = q.poll();
           int node = p.node;
           int weight = p.weight;
           int stops = p.stop;

           if(stops > k) continue;

           for(St ele: graph.get(node)){
              int o = ele.des;
              int w = ele.weight;

              if(stops <= k && dest[o] > weight + w){
                    dest[o] = weight + w;
                    q.add(new Pair(o, weight+w, stops+1));
                }
           }
        }

        return dest[dst] == (int)1e9? -1: dest[dst];
    }
}