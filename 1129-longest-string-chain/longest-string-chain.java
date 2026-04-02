class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(isCorrect(words[i], words[j])&& dp[i]<dp[j]+1){
                    dp[i] = 1+dp[j];
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    static boolean isCorrect(String a, String b){
        if(a.length() != b.length() + 1) return false;

        int i = 0, j = 0;
        int mismatch = 0;

        while(i < a.length()){
            if(j < b.length() && a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            } else {
                mismatch++;
                i++;
                if(mismatch > 1) return false;
            }
        }

        return true;
    }
}