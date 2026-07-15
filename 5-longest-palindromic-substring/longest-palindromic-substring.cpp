class Solution {
public:
    string longestPalindrome(string s) {
        if(s=="" && s.length() == 0) return "";

        int left = 0;
        int right = 0;

        for(int i=0;i<s.length();i++){
            int odd = expand(s, i, i);
            int even = expand(s, i, i+1);

            int maxLength = max(odd, even);

            if(maxLength > right-left+1){
                left = i-(maxLength-1)/2;
                right = i+(maxLength)/2;
            }
        }

        return s.substr(left, right-left+1);
    }
    int expand(string s, int left, int right){
        while(left>=0 && right < s.length() && s[left] == s[right]){
            left--;
            right++;
        }

        return right-left-1;
    }
};