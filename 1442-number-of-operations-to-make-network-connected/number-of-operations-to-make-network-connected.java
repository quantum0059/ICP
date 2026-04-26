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

        int findParent(int node){
            if(parent[node] != node){
                parent[node] = findParent(parent[node]);
            }

            return parent[node];
        }

        void unionBySize(int u, int v){
            int ul = findParent(u);
            int vl = findParent(v);

            if(ul == vl) return;
            if(size[ul]<size[vl]){
               parent[ul] = vl;
               size[vl]+=size[ul];
            }
            else{
                parent[vl] = ul;
                size[ul]+=size[vl];
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int m = connections[0].length;
        DisJointSet ds = new DisJointSet(n);

        int extraEdge = 0;

        for(int[] edge: connections){
            int e1 = edge[0];
            int e2 = edge[1];

            if(ds.findParent(e1) != ds.findParent(e2)){
                ds.unionBySize(e1, e2);
            }else{
                extraEdge++;
            }
        }
        int components = 0;

        for(int i=0;i<n;i++){
            if(ds.findParent(i) == i) components++;
        }

        if(extraEdge >= (components-1)){
            return components-1;
        }

        return -1;

        
    }
}