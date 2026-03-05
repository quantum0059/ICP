class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int count =0;

        char prev = s.charAt(0);

        for(int i=1;i<n;i++){
           char curr = s.charAt(i);

           if(curr == prev){
             if(curr == '0'){
                curr = '1';
             }else{
                curr = '0';
             }
             count++;
           }
           prev = curr;

        }

        return Math.min(count, n-count);
    }
}