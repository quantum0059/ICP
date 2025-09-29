class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r =0;
        int c = matrix[0].length-1;
        int n = matrix.length;
        int m = matrix[0].length;
        while(r<n && c>=0){
           if(matrix[r][c] == target){
             return true;
           }else if(matrix[r][c] < target){
             r++;
           }else{
            c--;
           }
        }

        return false;
    }
}
