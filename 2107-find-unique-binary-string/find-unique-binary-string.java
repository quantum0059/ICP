class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        if(n==1) return nums[0].equals("0")?"1":"0";
        String needed = "10";
        HashSet<String> set = new HashSet<>();
        for(String s: nums){
            set.add(s);
        }
        return helper(set, n, "");
    }

    static String helper(HashSet<String> set, int n, String temp){
        if(temp.length() == n){
            if(!set.contains(temp)) return temp;
            return null;
        }

        String left = helper(set, n, temp+"0");
        if(left != null) return left;
        return helper(set, n,temp+"1");
    }
}