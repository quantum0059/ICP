class StockSpanner {
    ArrayList<Integer> st;
    public StockSpanner() {
        st = new ArrayList<>();
    }
    
    public int next(int price) {
        st.add(price);

        int cnt = 1;
        if(st.size() == 1) return cnt;
        for(int i=st.size()-2;i>=0;i--){
            if(price>=st.get(i)){
                cnt++;
            }else{
                break;
            }
        }

        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */