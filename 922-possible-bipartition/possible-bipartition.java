class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<dislikes.length;i++){
            int a = dislikes[i][0];
            int b = dislikes[i][1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int []colors = new int[n+1];
        Arrays.fill(colors, -1);

        for(int i=1;i<=n;i++){
            if(colors[i] == -1){
                Queue<Integer> q = new LinkedList<>();
                colors[i] = 0;
                q.add(i);

                while(!q.isEmpty()){
                    int idx = q.poll();

                    for(int ele: graph.get(idx)){
                        if(colors[idx] == colors[ele]){
                            return false;
                        }

                       if (colors[ele] == -1) {
                            colors[ele] = 1 - colors[idx];
                            q.add(ele);
                        }
                    }
                }
            }
        }

        return true;

    }
}