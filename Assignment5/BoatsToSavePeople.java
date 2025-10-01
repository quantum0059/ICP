class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int count = 0;
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            if (arr[i] + arr[j] <= limit) {
                i++; 
                j--;
            } else {
                j--; 
            }
            count++;
        }

        return count;
    }
}
