class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int dr[] = {0, 1, 0, -1};
        int dc[] = {1, 0, -1, 0};
        
        int count =0;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, r, c , i, j, dr, dc);
                }
            }
        }
        return count;
    }

     void dfs(char[][] grid, int sr, int sc, int i, int j, int[] dr, int[] dc){
        
        if(i<0 || j<0 || i>=sr || j>=sc || grid[i][j] != '1') return;
        
        grid[i][j] = '0';
        for(int k=0;k<4;k++){
                dfs(grid, sr, sc, i+dr[k], j+dc[k], dr, dc);
            
        }
    }
}
