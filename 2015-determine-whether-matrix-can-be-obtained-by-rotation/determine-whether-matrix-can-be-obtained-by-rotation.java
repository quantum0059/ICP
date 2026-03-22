class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for(int k=0;k<4;k++){
            boolean equal = true;
            
            //check if equal
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j] != target[i][j]){
                        equal = false;
                        break;
                    }
                }
            }

            if(equal) return true;

           
                for(int i=0;i<n;i++){
                    for(int j=i;j<n;j++){
                        int temp = mat[i][j];
                        mat[i][j] = mat[j][i];
                        mat[j][i] = temp;
                    }
                }

                for(int[] arr: mat){
                    int left = 0;
                    int right = arr.length - 1;

                    while (left < right) {
                        int temp = arr[left];
                        arr[left] = arr[right];
                        arr[right] = temp;

                        left++;
                        right--;
                    }
                }
            


        }
        return false;
    }
}