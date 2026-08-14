class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int maxLength = Integer.MIN_VALUE;
         
        int left = 0;
        for(int right=0;right<s.length();right++){
          char c = s.charAt(right);
          map.put(c, map.getOrDefault(c, 0)+1);

          while(map.get(c)>2){
            map.put(s.charAt(left), map.get(s.charAt(left))-1);
            left++;

          }
          maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }
}