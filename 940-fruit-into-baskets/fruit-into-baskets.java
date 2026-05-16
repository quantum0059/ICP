class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int st = 0;
        int NumberOfFruits = 0;

        for(int i=0;i<fruits.length;i++){
           int fruit = fruits[i];

           while(st<fruits.length && map.size()==2 && !map.containsKey(fruit)){
             int ele = fruits[st];
             map.put(ele, map.get(ele)-1);
             if(map.get(ele) <=0 ){
                map.remove(ele);
             }
             st++;
           }

           map.put(fruit, map.getOrDefault(fruit, 0)+1);
           NumberOfFruits = Math.max(NumberOfFruits, i - st + 1);
        }


        return NumberOfFruits;
    }
}