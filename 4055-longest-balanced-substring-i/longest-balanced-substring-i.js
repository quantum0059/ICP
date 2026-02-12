var longestBalanced = function(s) {
    let n = s.length;
    let maxLen = 0;
    
    // Outer loop for the starting index of the substring
    for (let i = 0; i < n; i++) {
        let freq = new Map(); // This map stores char frequencies for the current substring s[i...j]
        // Inner loop for the ending index of the substring
        for (let j = i; j < n; j++) {
            let char = s[j];
            // Increment the frequency of the current character
            freq.set(char, (freq.get(char) || 0) + 1);
            
            // Extract all frequency values into a Set
            // If the Set size is 1, it means all characters in the current substring
            // have the same frequency, thus it's balanced.
            let freqValues = new Set(freq.values());
            
            if (freqValues.size === 1) {
                // Update maxLen with the length of the current balanced substring
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
    }
    return maxLen;
};