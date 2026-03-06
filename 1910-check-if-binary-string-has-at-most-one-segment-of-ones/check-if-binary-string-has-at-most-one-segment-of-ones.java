class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int count = 0;
        boolean flag = false;
        for(int i=0;i<n;i++){
            while(i<n && s.charAt(i) == '1'){
                i++;
                flag = true;
            }
            if(flag){
                count++;
                if(count>1){
                    return false;
                }

                flag = false;
            }
        }
            return count==0?false:true;
    }


}