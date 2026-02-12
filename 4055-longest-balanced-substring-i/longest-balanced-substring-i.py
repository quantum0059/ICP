class Solution:
    def longestBalanced(self, s: str) -> int:
        n = len(s)
        max_len = 0
        
        # Outer loop for the starting index of the substring
        for i in range(n):
            freq = {} # This map stores char frequencies for the current substring s[i...j]
            # Inner loop for the ending index of the substring
            for j in range(i, n):
                char = s[j]
                # Increment the frequency of the current character
                freq[char] = freq.get(char, 0) + 1
                
                # Extract all frequency values into a set
                # If the set size is 1, it means all characters in the current substring
                # have the same frequency, thus it's balanced.
                freq_values_set = set(freq.values())
                
                if len(freq_values_set) == 1:
                    # Update max_len with the length of the current balanced substring
                    max_len = max(max_len, j - i + 1)
                    
        return max_len