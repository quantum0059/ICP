class Solution {
    public long sumAndMultiply(int n) {
        long num = 1;
        long sum = 0;
        int nu = n;
        while(nu>0){
            int ele = nu%10;
            sum+=ele;
            nu/=10;
        }

        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(n);

        for(char c: s.toCharArray()){
            if(c!='0'){
                sb.append(c);
            }
        }
       num = sb.length() == 0 ? 0 : Long.parseLong(sb.toString());
        return num*sum;
    }
}