class Pair{
    int row;
    int col;
    int dis;
    Pair(int row, int col, int dis){
        this.row = row;
        this.col  = col;
        this.dis = dis;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Deque<Pair> q = new ArrayDeque<>();

        int[][] distance = new int[mat.length][mat[0].length];
        boolean[][] vis = new boolean[mat.length][mat[0].length];

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    vis[i][j] = true;
                    distance[i][j] = 0;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int dis = p.dis;

            for(int i=0;i<4;i++){
                int nr = row+dr[i];
                int nc = col+dc[i];

                if(nr>=0 && nc>=0 && nr<mat.length && nc<mat[0].length && !vis[nr][nc]){
                    q.add(new Pair(nr, nc, dis+1));
                    distance[nr][nc] = dis+1;
                    vis[nr][nc] = true;   
                }

                
            }


        }

        return distance;


    }
}