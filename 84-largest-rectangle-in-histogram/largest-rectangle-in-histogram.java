class Solution {
    public int largestRectangleArea(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && height[st.peek()] > height[i]){
               int nse = i;
               int ele = height[st.peek()];
               st.pop();
               int pse = st.isEmpty()?-1:st.peek();

                maxArea = Math.max(maxArea, ele*(nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = n;
            int ele = height[st.peek()];
            st.pop();
            int pse = st.isEmpty()?-1:st.peek();

            maxArea = Math.max(maxArea, ele*(nse-pse-1));
        }
        return maxArea;
    }
}