class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //Using Threads to sort arrays at same time
        Thread t1 = new Thread(() -> {
            Arrays.sort(g);
        });
        Thread t2 = new Thread(() -> {
            Arrays.sort(s);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        int l = 0;
        int r = 0;
        int n = g.length;
        int m = s.length;
        // g -> greed  s-> cookies

        while (l < n && r < m) {

            if (g[l] <= s[r]) { // greed satisfied
                l++;
                r++;
            } else {
                r++;
            }

        }

        return l;
    }
}