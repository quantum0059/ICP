class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nse = NSE(heights);
        int[] pse = PSE(heights);
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
          int curr = heights[i]*(nse[i]-pse[i]-1);
          max = Math.max(max, curr);
        }

        return max;
    }

    int[] NSE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            
            res[i] = st.isEmpty()? arr.length : st.peek();
            st.push(i);
        }
        return res;
    }

    int[] PSE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            
            res[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return res;
    }
}