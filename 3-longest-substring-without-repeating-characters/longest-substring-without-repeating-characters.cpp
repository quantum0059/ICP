class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> set;
        int st = 0;
        int maxLength = 0;
        for(int rt=0;rt<s.length();rt++){
            char c = s[rt];

            while(set.contains(c)){
                set.erase(s[st]);
                st++;
            }

            maxLength = max(maxLength, rt-st+1);
            set.insert(c);
        }

        return maxLength;
    }
};