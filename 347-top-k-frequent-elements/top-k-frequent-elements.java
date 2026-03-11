class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();

        for(int n : nums){
            freq.put(n, freq.getOrDefault(n,0)+1);
        }

        TreeMap<Integer, List<Integer>> tree = new TreeMap<>(Collections.reverseOrder());

        for(int i : freq.keySet()){
            int f = freq.get(i);
            tree.computeIfAbsent(f, x -> new ArrayList<>()).add(i);
        }
        
        int [] arr = new int[k];
        int j = 0;

        for(int i : tree.keySet()){
            for(int num : tree.get(i)){
                if(j == k) break;
                arr[j++] = num;
            }
            if(j == k) break;
        }

        return arr;
    }
}