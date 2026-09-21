class Solution {
    public int minRefuelStops(int target, int tank, int[][] stations) {
        int max_you_can_reach = tank;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));

        int count = 0;

        int idx=0;

        while(max_you_can_reach<target){
           while(idx<stations.length && stations[idx][0]<=max_you_can_reach){
            pq.offer(stations[idx][1]);
            idx++;
           }
           if(pq.isEmpty()) return -1;
           max_you_can_reach+=pq.poll();
           count++;
        }

        return count;
    }
}