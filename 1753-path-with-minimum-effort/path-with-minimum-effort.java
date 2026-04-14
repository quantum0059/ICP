class Solution {
    static class Pair{
        int row;
        int col;
        int cost;
        Pair(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

       PriorityQueue<Pair> q = new PriorityQueue<>(
            (a, b) -> a.cost - b.cost
        );


        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        int[][] dis = new int[n][m];
        for(int[] arr: dis){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        q.add(new Pair(0, 0, 0));
        dis[0][0] = 0;
        int res = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row=p.row;
            int col = p.col;
            int cost = p.cost;

            if(row == n-1 && col == m-1){
                return cost;
            }

            for(int i=0;i<4;i++){
                int nr = row+dr[i];
                int nc = col+dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m ){
                    int edge = Math.abs(heights[row][col] - heights[nr][nc]);

                    int newEffort = Math.max(cost, edge);

                    if (newEffort < dis[nr][nc]) {
                        dis[nr][nc] = newEffort;
                        q.add(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }


        return res;

    }
}