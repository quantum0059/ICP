class Solution {
    public boolean canReach(int[] arr, int start) {
     return DFS(arr, start);   
    }

    boolean DFS(int[] arr, int i){
        if(i<0 || i>= arr.length || arr[i]<0) return false;
        if(arr[i] == 0){
            return true;
        }
        int jump = arr[i];
        arr[i]*=-1;
        return DFS(arr, i+jump) || DFS(arr, i-jump);
    }
}