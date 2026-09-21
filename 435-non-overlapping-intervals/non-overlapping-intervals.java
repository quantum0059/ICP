class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int prev = intervals[0][1];
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            int next = intervals[i][0];
            if(prev>next){
              count++;
              prev = Math.min(prev, intervals[i][1]);
            }else{
                prev  = intervals[i][1];
            }
        }

        return count;
    }
}
       
