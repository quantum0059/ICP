class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;


        if(n2 == 1 && n1 == 1){
            return new int[]{-1};
        }

        int[] arr = new int[n2];
        Stack<Integer> st = new Stack<>();
        int[] arr1 = new int[n1];

        for(int i=n2-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }

            if(st.isEmpty()){
                arr[i] = -1;
            }else{
                arr[i] = st.peek();
            }

            st.push(nums2[i]);
        }
 
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                 if(nums1[i] == nums2[j]){
                    arr1[i] = arr[j];
                 }
            }
        }

        return arr1;

    }
}