class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> m = new ArrayList<>();
        int[] prev = intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] next = intervals[i];
            if(next[0] <= prev[1]){
                prev[1] = Math.max(next[1],prev[1]);
            }else{
                m.add(prev);
                prev = next;
            }
        }
           m.add(prev);

        return m.toArray(new int[m.size()][]);  
    }
}