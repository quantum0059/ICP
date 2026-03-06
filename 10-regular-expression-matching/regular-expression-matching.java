class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        return helper(s, p, 0, 0);
    }

    static boolean helper(String s, String p, int idx1, int idx2){
       
        if(idx2>=p.length()){
            return idx1>=s.length();
        } 

        boolean match = (idx1<s.length()) && (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '.');

        if(idx2+1<p.length() && p.charAt(idx2+1)=='*'){
           return (helper(s, p, idx1, idx2+2) || (match && helper(s, p, idx1+1, idx2)));
        }

        if(match){
            return helper(s, p, idx1+1, idx2+1);
        }

        return false;
    }
}