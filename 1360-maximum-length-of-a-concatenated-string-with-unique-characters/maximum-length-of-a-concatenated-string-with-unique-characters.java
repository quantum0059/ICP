class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        
        String temp = "";

        return length( arr, n,  0, temp);
    }

    int length(List<String> arr, int n ,int idx, String temp){
         if(idx>=n){
            return temp.length();
         }

         int take=0;
         int notTake= 0;

         if(isDuplicate(temp, arr.get(idx))){
            return length(arr, n, idx+1, temp);
         }else{
           
           notTake = length(arr, n, idx+1, temp);
           temp+=arr.get(idx);
           take = length(arr, n, idx+1, temp);
            
         }

         return Math.max(notTake, take);
    }

    boolean isDuplicate(String s1, String s2){
        int[] hashTable = new int[26];

        for(char a: s1.toCharArray()){
            if(hashTable[a-'a'] > 0){
                return true;
            }

            hashTable[a-'a']++;
            
        }

        for(char a: s2.toCharArray()){
            if(hashTable[a-'a'] > 0){
                return true;
            }
            hashTable[a-'a']++;
        }
         
         return false; // no duplicate

    }
}