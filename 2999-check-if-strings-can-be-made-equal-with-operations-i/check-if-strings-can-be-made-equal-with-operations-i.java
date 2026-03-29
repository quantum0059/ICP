class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int n = s1.length();

        for(int i=0;i<n; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(i+2<n && s1.charAt(i) != s2.charAt(i+2)){
                    return false;
                }
                if(i+2>=n &&  s1.charAt(i) != s2.charAt(i-2)){
                   return false;
                }
            }
        }

        return true;
    }
}