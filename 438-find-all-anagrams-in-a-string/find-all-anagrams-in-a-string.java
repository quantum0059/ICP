class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arr = new int[26];
        List<Integer> index = new ArrayList<>();
        for(char c: p.toCharArray()){
            arr[c-'a']++;
        }  
        int i =0;
        int j =0;
        while(i<s.length() && j<s.length()){
            char c = s.charAt(i);
            arr[c-'a']--;

            if(i-j+1>=p.length()){
                
                boolean flag = true;
                for(int k=0;k<26;k++){
                     if(arr[k]!= 0){
                        flag = false;
                        break;
                     }
                }
                if(flag) index.add(j);
                char a = s.charAt(j);
                arr[a-'a']++;
                j++;

            }

            i++;
            
            
        }

        return index;

    }
}