class Solution {
    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(s, 0, n-1, dp)-1;
    }
    int helper(String s, int i, int n, int[] dp){
        if(i>n) return 0;

        if(dp[i] != -1) return dp[i];

        int minCuts = Integer.MAX_VALUE;

        for(int k=i;k<=n;k++){
            if(isPalindrome(s, i, k)){
                int count = 1+helper(s, k+1, n, dp);
                minCuts = Math.min(minCuts, count);
            }
        }
        return dp[i] = minCuts;
    }

    boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;

    }
}