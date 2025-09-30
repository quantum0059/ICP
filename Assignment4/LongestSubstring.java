class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int maxLength = 0;
        int st = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            while(set.contains(c)){
                set.remove(s.charAt(st));
                st++;
            }

            set.add(c);

            maxLength = Math.max(maxLength, i-st+1);
        }

        return maxLength;
    }
}
