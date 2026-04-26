class Solution {
    static class DisJointSet{
        int[] parent, size;
        DisJointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int n){
            if(parent[n] != n){
                parent[n] = findParent(parent[n]);
            }

            return parent[n];
        }

        void unionBySize(int u, int v){
            int ul = findParent(u);
            int vl = findParent(v);

            if(ul == vl) return;
            if(size[ul]< size[vl]){
                parent[ul] = vl;
                size[vl]+=size[ul];
            }else{
                parent[vl] = ul;
                size[ul]+=size[vl];
            }
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        DisJointSet ds = new DisJointSet(n*m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0) continue;

                int[] dr = {0, 1, 0, -1};
                int[] dc = {1, 0, -1, 0};

                for(int k=0;k<4;k++){
                    int newRow = i+dr[k];
                    int newCol = j+dc[k];

                    if(newRow>=0 && newCol>=0 && newCol<m && newRow<n && grid[newRow][newCol] == 1){
                        int n1 = (newRow*m)+newCol;
                        int n2 = (i*m)+j;
                        ds.unionBySize(n1, n2);
                    }
                }
            }
        }
        int maxSize = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (grid[i][j] == 1) continue;

                Set<Integer> set = new HashSet<>();
                int sizeTotal = 1; 
                int[] dr = {0, 1, 0, -1};
                int[] dc = {1, 0, -1, 0};

                for(int k=0;k<4;k++){
                    int newRow = i+dr[k];
                    int newCol = j+dc[k];
                    if(newRow>=0 && newCol>=0 && newCol<m && newRow<n){
                        if(grid[newRow][newCol] == 1){
                            int node = (newRow*m)+newCol;
                            int parent = ds.findParent(node);
                            set.add(parent);
                        }
                    }
                }
                for(int pr: set){
                    sizeTotal+=ds.size[pr];
                }
                maxSize = Math.max(maxSize, sizeTotal);
            }
        }

        return maxSize == Integer.MIN_VALUE?m*n:maxSize;
    }
}