class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int zero = 0;
        for(char c: s.toCharArray()){
              if(c=='0'){
                zero++;
              }
        }

        int output = zero;
        int one = 0;

        for(char c: s.toCharArray()){
            if(c=='0') zero--;
            if(c=='1') one++;

            output = Math.min(output, one+zero);
        }

        return output;
    }
}