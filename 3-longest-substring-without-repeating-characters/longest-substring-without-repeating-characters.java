class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int st = 0;
        for(int i=0;i<s.length();i++){
           char c = s.charAt(i);
           while(st<s.length() && map.containsKey(c) && map.get(c) != 0){
            char a = s.charAt(st);
            map.put(a, map.get(a)-1);
            st++;
           }
           maxLength = Math.max(maxLength, i-st+1);
           map.put(c, 1);
           
        }

        return maxLength;
    }
}