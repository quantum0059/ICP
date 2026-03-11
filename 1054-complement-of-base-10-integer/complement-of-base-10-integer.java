class Solution {
    public int bitwiseComplement(int n) {
        char[] str = Integer.toBinaryString(n).toCharArray();

        for(int i=0;i<str.length;i++){
            if(str[i] == '0'){
                str[i] = '1';
            }else{
                str[i] = '0';
            }
        }

        int res = 0;
        int count = 0;
        for(int i=str.length-1;i>=0;i--){
            if(str[i] == '1'){
                res+=(int)Math.pow(2, count);
            }
            count++;
        }

        return res;
    }
}