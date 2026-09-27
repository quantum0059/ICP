class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();

        int i = nums.length-2;

        //idx of ele which is lesser from the right side;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
         if (i < 0) {
            return -1;
        }

        //idx of ele which is just greater then the lesser ele;
        int j = nums.length-1;
        while(nums[i]>=nums[j]){
            j--;
        }

        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        int left = i+1;
        int right = nums.length-1;

        while(left < right){
            char t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }

        long ans = Long.parseLong(new String(nums));

        return ans > Integer.MAX_VALUE?-1:(int) ans;

    }
}