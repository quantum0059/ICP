class Solution {
    public int compress(char[] chars) {
        int st =0;
        int end = 0;
        while(end < chars.length) {
           char s = chars[end];
            int counter = 0;
            while(end < chars.length && chars[end] == s) {
                counter++;
                end++;
            }

            chars[st++] = s;

            if(counter > 1) {
                for(char ch: String.valueOf(counter).toCharArray()){
                    chars[st++] = ch;
                }
            }
        }
         

       return st;
    }
}