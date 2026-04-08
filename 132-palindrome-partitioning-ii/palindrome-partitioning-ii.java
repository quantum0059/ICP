class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        for(int i=n-1;i>=0;i--){
            int minCuts = Integer.MAX_VALUE;

            for(int k=i;k<n;k++){
                if(isPalindrome(i, k, s)){
                    int cuts = 1+dp[k+1];
                    minCuts = Math.min(minCuts, cuts);
                }
            }
            dp[i] = minCuts;
        }
        return dp[0]-1;

    }
    static int helper(int i, int n, String s, int[] dp){
        if(i==n) return 0;

        if(dp[i] != -1) return dp[i];

        int minCuts = Integer.MAX_VALUE;

        for(int k=i;k<n;k++){
            if(isPalindrome(i, k, s)){
               int cuts = 1+helper(k+1, n, s, dp);
               minCuts = Math.min(minCuts, cuts);
            }
        }

        return dp[i] = minCuts;
    }
    static boolean isPalindrome(int i, int j, String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;

    }
}