#include <vector>     // For std::vector
#include <numeric>    // For std::iota (not used here, but common for fill)
#include <algorithm>  // For std::max, std::min

class Solution {
public:
    
    std::vector<std::vector<double>> dp;
    int initialPoured; 

    double helper(int r, int c) {
        if (c < 0 || c > r) {
            return 0.0; 
        }

        if (dp[r][c] != -1.0) {
            return dp[r][c];
        }


        if (r == 0 && c == 0) {
            return dp[r][c] = initialPoured;
        }

        double leftOverflow = std::max(0.0, (helper(r - 1, c - 1) - 1.0) / 2.0);
        

        double rightOverflow = std::max(0.0, (helper(r - 1, c) - 1.0) / 2.0);

        return dp[r][c] = leftOverflow + rightOverflow;
    }

    double champagneTower(int poured, int query_row, int query_glass) {
        
        dp.resize(query_row + 1, std::vector<double>(query_row + 1, -1.0));
        this->initialPoured = poured; 

        double totalChampagne = helper(query_row, query_glass);

        return std::min(1.0, totalChampagne);
    }
};