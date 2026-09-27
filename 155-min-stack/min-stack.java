class MinStack {
    static class Pair{
        int val;
        int min;

        Pair(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    protected Stack<Pair>  st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
        st.push(new Pair(val, val));
        return;
    }
        int min_value = st.peek().min;

        min_value = Math.min(min_value, val);

        st.push(new Pair(val, min_value));
    }
    
    public void pop() {
       st.pop();   
    }
    
    public int top() {
        return st.isEmpty() ? -1 :st.peek().val;
    }
    
    public int getMin() {
        return st.isEmpty() ? -1:st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */