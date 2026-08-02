class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] arr = new int[n+1];
        
        arr[1] = 1;

        int i2=1, i3=1, i5 =1;

        for(int i=2;i<arr.length;i++){
            int i2Ugly = arr[i2]*2;
            int i3Ugly = arr[i3]*3;
            int i5Ugly = arr[i5]*5;

            int min = Math.min(i2Ugly, Math.min(i3Ugly, i5Ugly));
            arr[i] = min;

            if(min == i2Ugly){
                i2++;
            }
            if(min == i3Ugly){
                i3++;
            }
            if(min == i5Ugly){
                i5++;
            }
        }

        return arr[n];
    }
   
}