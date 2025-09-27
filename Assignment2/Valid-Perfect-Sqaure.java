class Solution {
    public boolean isPerfectSquare(int num) {
        
        if(num == 1) return true;
        long l =1;
        long r = num/2;

        boolean ans = false;

        

        while(l<=r){
            long mid = l+(r-l)/2;
            long sq = mid*mid;
            if(sq == num) {
                ans = true;
            }

            if(sq>num){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return ans;
    }
}
