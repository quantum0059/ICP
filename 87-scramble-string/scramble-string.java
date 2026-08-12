class Solution {
    Map<String, Boolean> map;
    public boolean isScramble(String s1, String s2) {
        map = new HashMap<>();
        return helper(s1, s2);
    }

    boolean helper(String s1, String s2){
        if(s1.equals(s2)) return true;

        if(s1.length() != s2.length()) return false;
        String key = s1+" "+s2;
        if(map.get(key) != null) return map.get(key);

        boolean result = false;
        int n = s1.length();

        for(int i=1;i<n;i++){
            boolean swapped = helper(s1.substring(0, i), s2.substring(0, i)) && helper(s1.substring(i), s2.substring(i));
            boolean notSwapped = helper(s1.substring(i, n), s2.substring(0, n-i)) && helper(s1.substring(0, i), s2.substring(n-i, n));

            if(swapped || notSwapped){
                result = true;
                break;
            }

        }

         map.put(key, result);
         return map.get(key);
    }
}