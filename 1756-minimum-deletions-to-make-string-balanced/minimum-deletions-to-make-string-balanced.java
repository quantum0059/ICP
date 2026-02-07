class Solution {
    public int minimumDeletions(String s) {
        if(s.length() == 1){
            return 0;
        }

        int count = 0;
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
           char c = s.charAt(i);
           if(!st.isEmpty() && st.peek() == 'b' && c=='a'){
             st.pop();
             count++;
           }else{
            st.push(c);
           }
        }

        return count;
    }
}