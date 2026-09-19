class Solution {
    public int compress(char[] chars) {
        int st =0;
        StringBuilder sb = new StringBuilder();
        int end = 0;
        while(end < chars.length) {
           int counter = 0;

            while(end < chars.length && chars[end] == chars[st]) {
                counter++;
                end++;
            }

            sb.append(chars[st]);

            if(counter > 1) {
                sb.append(counter);
            }

            st = end;
        }
         for (int i = 0; i < sb.length(); i++) {
        chars[i] = sb.charAt(i);
    }

    return sb.length();
    }
}