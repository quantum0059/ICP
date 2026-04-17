class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int)1e9;
        int m = edges.length;
        
        int[][] dist = new int[n][n];

        for(int[] arr: dist){
            Arrays.fill(arr, INF);
        }
        for(int i=0;i<n;i++){
            dist[i][i] = 0;
        }

        for(int[] arr: edges){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];

            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                   if(dist[i][via] != INF && dist[via][j] != INF){
                     dist[i][j] = Math.min(dist[i][j], (dist[i][via]+dist[via][j]));
                   }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(i != j  &&dist[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(min >= count){
                min = count;
                max = Math.max(max, i);
            }
        }
        return max;
    }
}