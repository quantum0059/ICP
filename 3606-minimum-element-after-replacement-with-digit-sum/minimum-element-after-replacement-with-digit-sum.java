class Solution {
    public int minElement(int[] nums) {

        for(int i=0;i<nums.length;i++){
            nums[i] = newEle(nums[i]);
        }

        return Arrays.stream(nums).min().getAsInt();
    }

    int newEle(int num){
        int sum = 0;

        while(num>0){
            sum+=num%10;
            num/=10;
        }

        return sum;
    }
}