class Solution {
    public boolean isAnagram(String s, String t) {
        int n = t.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
           map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        for(int i=0;i<n;i++){
            char c = t.charAt(i);
            if(map.containsKey(t.charAt(i))){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) map.remove(c);
            }else{
                return false;
            }

        }

        

        return map.size()==0;
    }
}