class Solution {
public:
    int longestBalanced(std::string s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int freq[26] = {0};
            int distinct = 0;
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int idx = s[j] - 'a';

                if (freq[idx] == 0)
                    distinct++;

                freq[idx]++;
                maxFreq = std::max(maxFreq, freq[idx]);

                // Check if balanced
                int minFreq = 1e9;
                bool valid = true;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        minFreq = std::min(minFreq, freq[k]);
                    }
                }

                if (maxFreq == minFreq) {
                    maxLen = std::max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
};
