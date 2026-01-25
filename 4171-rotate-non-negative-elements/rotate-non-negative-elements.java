class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;
        if(nums.length<=1) return nums;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                list.add(nums[i]);
            }
        }

        int size = list.size();

        if(size == 0) return nums;

        k%=size;
        if(k==0) return nums;

        for(int i=0;i<k;i++){
            list.addLast(list.removeFirst());
        }

        Iterator<Integer> it = list.iterator();
        for(int j=0;j<nums.length;j++){
            if(nums[j]>=0){
                nums[j] = it.next();
            }
        }

        return nums;
    }
}