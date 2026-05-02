class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i=2;i<=n;i++){
            if(isValid(i)){
                count++;
            }
        }
        return count;
    }
    static boolean isValid(int n){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(0, 0);
        map.put(8, 8);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(9, 6);

        int res = 0;
        int temp = n;
        List<Integer> digit = new ArrayList<>();

        while(temp>0){
            int d = temp%10;
            if(!map.containsKey(d)){
                return false;
            }else{
                digit.add(map.get(d));
            }
            temp/=10;
        }

        Collections.reverse(digit);

        for(int i=0;i<digit.size();i++){
            res+=digit.get(i);
            if(i!=digit.size()-1){
                res*=10;
            }
        }

        return res != n;
    }
}