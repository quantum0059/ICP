class Solution {
    static class Pair{
        int row;
        int col;
        int time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int numberOfOranges = 0;
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    vis[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }else if(grid[i][j] == 1){
                    numberOfOranges++;
                }
            }
        }
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int t = 0;
        while(!q.isEmpty()){
           Pair p = q.poll();
           int row = p.row;
           int col = p.col;
           t = p.time;

           for(int i=0;i<4;i++){
            int newRow = dr[i]+row;
            int newCol = dc[i]+col;

            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol] == 1 && !vis[newRow][newCol]){
                vis[newRow][newCol] = true;
                q.add(new Pair(newRow, newCol, t+1));
                numberOfOranges--;
            }
           }
        }
        return numberOfOranges == 0?t:-1;

    }
}