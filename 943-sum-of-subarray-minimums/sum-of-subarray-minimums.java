class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse = NSE(arr);
        int[] psee = PSEE(arr);

        long mod = 1_000_000_007L;
        long total = 0;
        for(int i=0;i<arr.length;i++){
           long left  = i - psee[i];
           long right = nse[i] - i;
           total = (total + arr[i] * left % mod * right % mod) % mod;
        }

        return (int)total;
    }
    int[] NSE(int[] arr){
        int[] res = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            res[i] = st.isEmpty()?arr.length:st.peek();

            st.push(i);
        }

        return res;
    }
    int[] PSEE(int[] arr){
         int[] res = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            res[i] = st.isEmpty()?-1:st.peek();

            st.push(i);
        }

        return res;
    }
}