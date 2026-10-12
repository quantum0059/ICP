class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        
        int j =0;
        for(int i:nums){
            arr[j] = String.valueOf(i);
            j++;
        }

        Arrays.sort(arr, (a,b)->(b+a).compareTo(a+b));

        if(arr[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String i: arr){
            sb.append(i);
        }
        return sb.toString();
    }
}