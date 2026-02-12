class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        if(n == 1){
            return 1;
        }

        int maxLen = 0;
       
       for(int i=0;i<n;i++){
         HashMap<Character, Integer> freq = new HashMap<>();
         for(int j=i;j<n;j++){
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0)+1);
             HashSet<Integer> set = new HashSet<>();
            set.addAll(freq.values());
            if(set.size() == 1){
                 maxLen = Math.max(maxLen, j-i+1);
            }
         }
       }
     return maxLen;

    }
}