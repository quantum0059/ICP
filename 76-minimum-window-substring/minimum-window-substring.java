class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int st = 0;
        int startingIdx = -1;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int r = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            if(map.containsKey(c) && map.get(c)>0){
                count++;
            }
            map.put(c, map.getOrDefault(c, 0)-1);

            while(count == m){
                if(r-st+1<minLength){
                    minLength = r-st+1;
                    startingIdx = st;
                }

                char a = s.charAt(st);
                map.put(a, map.getOrDefault(a, 0)+1);
                if(map.get(a) > 0){
                    count--;
                }
                st++;
            }
            r++;
        }

        
        return startingIdx == -1 ? "" : s.substring(startingIdx,startingIdx+minLength);

    }
}