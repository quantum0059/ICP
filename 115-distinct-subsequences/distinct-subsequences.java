class Solution {
    static int[][] dp;

    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        StringBuilder sb = new StringBuilder();
        return helper(s, t, 0, sb);
    }

    static int helper(String s, String t, int idx, StringBuilder sb) {

        if (sb.length() > 0) {
            int last = sb.length() - 1;
            if (sb.charAt(last) != t.charAt(last)) {
                return 0;
            }
        }

        
        if (dp[idx][sb.length()] != -1) {
            return dp[idx][sb.length()];
        }

        
        if (idx == s.length()) {
            return dp[idx][sb.length()] =
                    (sb.length() == t.length()) ? 1 : 0;
        }

        if (sb.length() == t.length()) {
            return dp[idx][sb.length()] = 1;
        }

        int count = 0;

       
        sb.append(s.charAt(idx));
        count += helper(s, t, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        
        count += helper(s, t, idx + 1, sb);

        return dp[idx][sb.length()] = count;
    }
}
