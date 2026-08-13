class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];

        int res = -1;

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }

        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==1){
                res=i;
                break;
            }
        }
        return res;
    }
}