class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        int count = 0;
        boolean[] isVis = new boolean[s.length];
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0, r=0;
        while(l<s.length){
          if(r<g.length && g[r]<=s[l]){
            r++;
          }
          l++;   
        }

        return r;
    }
}