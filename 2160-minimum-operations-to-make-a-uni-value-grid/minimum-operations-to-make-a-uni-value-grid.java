class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               list.add(grid[i][j]);
            }
        }

        int size = list.size();
        Collections.sort(list);

        int target = list.get(size/2);
        int steps = 0;
        for(int i: list){
            if(target%x != i%x){
                return -1;
            }
            steps+=Math.abs(target-i)/x;
        }

        return steps;

    }
}