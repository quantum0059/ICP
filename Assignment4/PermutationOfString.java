class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashSet<String> set = new HashSet<>();
        String r = sort(s1);
        int length = s1.length();
        for(int i=0;i<=s2.length()-length;i++){
                set.add(sort(s2.substring(i, i+length)));
                if(set.contains(r)){
                    return true;
                    
                }
            
        }

        return false;
    }

    static String sort(String s){
        char[] ch = s.toCharArray();

        Arrays.sort(ch);

        return new String(ch);
    }
}
