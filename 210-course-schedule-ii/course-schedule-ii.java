class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            graph.get(b).add(a);
        }

        int indegree[] = new int[n];
        for(int i=0;i<n;i++){
            for(int ele: graph.get(i)){
                indegree[ele]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int[] ans = new int[n];
        int i=0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[i++] = node;

            for(int ele: graph.get(node)){
                indegree[ele]--;
                if(indegree[ele] == 0){
                    q.add(ele);
                }
            }
        }

        return i == n? ans: new int[]{};
    }
}