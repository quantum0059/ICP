class Solution {
    public int maxDistance(int[] colors) {
      int max = 0;

      int i=0;
      int j=colors.length-1;

      while(j>0){
        if(colors[i] != colors[j]){
            max = Math.max(max, (j-i));
        }
        j--;
      }  

      i=0;
      j=colors.length-1;
      while(i<j){
        if(colors[i] != colors[j]){
            max = Math.max(max, (j-i));
        }
        i++;
      }

      return max;
    }
}