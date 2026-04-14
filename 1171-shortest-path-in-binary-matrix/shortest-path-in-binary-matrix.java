class Solution {
    static class Pair{
        int r;
        int c;
        int dis;
        Pair(int r, int c, int dis){
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        if(grid[0][0] == 1) return -1;

        q.add(new Pair(0, 0, 1));
        grid[0][0] = 1;

        while(!q.isEmpty()){
            Pair p = q.poll();

            int r = p.r;
            int c = p.c;
            int dis = p.dis;
            if(r==n-1 && c==m-1) return dis;

            for(int i=0;i<8;i++){
                int newRow = r+dr[i];
                int newCol = c+dc[i];

                if(newRow>=0 && newCol>=0 && newRow<n && newCol<m && grid[newRow][newCol] == 0){
                    q.add(new Pair(newRow, newCol, dis+1));
                    grid[newRow][newCol] = 1;
                }
            }
        }
        return -1;
    }
}