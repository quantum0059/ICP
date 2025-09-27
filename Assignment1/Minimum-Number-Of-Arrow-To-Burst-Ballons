class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int n = points.length;
        int s = points[0][0];
        int e = points[0][1];
        int c = 1;
        for (int i = 1; i < n; i++) {
            if (e >= points[i][0]) {
                s = Math.max(s, points[i][0]);
                e = Math.min(e, points[i][1]);
            } else {
                c++;
                s = points[i][0];
                e = points[i][1];
            }
        }
        return c;
    }
}
