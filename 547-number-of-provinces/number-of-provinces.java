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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;

        DisJointSet ds = new DisJointSet(n);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i!=j && isConnected[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }

        int countProv = 0;
        for(int i=0;i<n;i++){
            if(ds.findParent(i) == i) countProv++;
        }

        return countProv;
    }
}