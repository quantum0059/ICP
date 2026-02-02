class Solution {
    static class Pair{
        int val;
        long time;
        Pair(int val, long time){
            this.val = val;
            this.time = time;
        }
    }
    public int countPaths(int n, int[][] roads) {
         int MOD = (int)1e9 + 7;
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();  
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int arr[]: roads){
            int a = arr[0];
            int b = arr[1];
            int dis = arr[2];

            graph.get(a).add(new Pair(b, dis));
            graph.get(b).add(new Pair(a, dis));
        }

        int count =0;

        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> Long.compare(a.time, b.time));
            q.offer(new Pair(0, 0));
            long[] dis = new long[n];
            int[] way = new int[n];
            Arrays.fill(dis, Long.MAX_VALUE);
            dis[0] = 0;
            way[0] = 1;

            while(!q.isEmpty()){
                Pair p = q.poll();
                int val = p.val;
                long time = p.time;

                if(time > dis[val]) continue;

                for(Pair ele: graph.get(val)){
                    int e = ele.val;
                    long newTime = ele.time+time;
                    if(newTime < dis[e]){
                        dis[e] = newTime;
                        way[e] = way[val];
                        q.offer(new Pair(e, newTime));
                    }else if(newTime == dis[e]){
                        way[e] = (way[e]+way[val])%MOD;
                    }
                }
            }
        return way[n-1];
    }
}