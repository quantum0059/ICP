class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c == '*'){
                if(sb.length()>0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }else if(c=='#'){
                String temp = sb.toString();
                sb.append(temp);
            }else if(c=='%'){
                sb.reverse();
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}