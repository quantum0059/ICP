class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] c= str.toCharArray();

            Arrays.sort(c);

            String n = new String(c);

            map.putIfAbsent(n, new ArrayList<>());
            map.get(n).add(str);
        }

        List<List<String>> list = new ArrayList<>();

        for(List<String> l: map.values()){
            list.add(new ArrayList<>(l));
        }

        return list;
    }
}