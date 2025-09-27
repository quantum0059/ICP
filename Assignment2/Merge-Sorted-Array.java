class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l =0;
        int k=0;
        int i=0;
        int arr[] = new int[m+n];
        while(l<m && k<n){
            if(nums1[l] < nums2[k]){
                   arr[i] = nums1[l];
                    l++;i++;
            }else{
                arr[i] = nums2[k];
                k++;i++;
            }
        }

        while(l<m){
            arr[i] = nums1[l];
            i++;l++;
        }

        while(k<n){
            arr[i] = nums2[k];
            i++;k++;
        }
        for(int j=0;j<arr.length;j++){
             nums1[j] = arr[j];
        }
    }
}
