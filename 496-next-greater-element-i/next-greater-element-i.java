class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;


        if(n2 == 1 && n1 == 1){
            return new int[]{-1};
        }
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=n2-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }

            map.put(nums2[i], st.isEmpty() ? -1: st.peek());

            st.push(nums2[i]);
        }
 
        int[] arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            arr1[i] = map.get(nums1[i]);
        }

        return arr1;

    }
}