class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         ArrayList<Integer> list = new ArrayList<>();
        if(s.length()<p.length()){
            return list;
        }
        int k=p.length();
        int[] parr=new int[26];
        int[] sarr=new int[26];
        for(int i=0;i<k;i++){
            parr[p.charAt(i)-'a']++;
            sarr[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(parr,sarr)){
            list.add(0);
        }
        for(int i=k;i<s.length();i++){
            sarr[s.charAt(i)-'a']++;
            sarr[s.charAt(i-k)-'a']--;

            if(Arrays.equals(parr,sarr)){
                list.add(i-k+1);
            }
        }
        return list;
    }
}
