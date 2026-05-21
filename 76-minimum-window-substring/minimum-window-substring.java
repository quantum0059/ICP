class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int m = t.length();

        int st = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int startingIdx = -1;

        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(map.containsKey(c) && map.get(c)>0){
                count++;
            }
            map.put(c, map.getOrDefault(c, 0)-1);

            while(count == m){
                if(minLength > r-st+1){
                    minLength = r-st+1;
                    startingIdx = st;
                }

                map.put(s.charAt(st), map.get(s.charAt(st))+1);
                if(map.get(s.charAt(st))>0) count--;
                st++;
            }
        }

        return startingIdx == -1 ? "": s.substring(startingIdx, startingIdx+minLength);
    }
}