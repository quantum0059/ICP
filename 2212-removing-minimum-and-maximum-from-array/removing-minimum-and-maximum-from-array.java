class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        // Edge case: if there's only one element, we must delete it.
        if (n == 1) {
            return 1;
        }

        int minIdx = 0;
        int maxIdx = 0;
        // Initialize with the first element's value and index
        int minEle = nums[0];
        int maxEle = nums[0];

        // Step 1: Find the indices of the minimum and maximum elements
        for (int i = 0; i < n; i++) {
            if (nums[i] < minEle) {
                minEle = nums[i];
                minIdx = i;
            }
            if (nums[i] > maxEle) {
                maxEle = nums[i];
                maxIdx = i;
            }
        }

        // Step 2: Calculate costs for the three strategies

        // Strategy 1: Remove both from the front
        // We need to delete elements from index 0 up to the maximum of minIdx and maxIdx.
        int ans1 = Math.max(minIdx, maxIdx) + 1;

        // Strategy 2: Remove both from the back
        // We need to delete elements from the minimum of minIdx and maxIdx up to n-1.
        int ans2 = n - Math.min(minIdx, maxIdx);

        // Strategy 3: Remove one from front, one from back
        // Calculate the minimum deletions to remove the minEle (from its closest end)
        int minDeletionsForMin = Math.min(minIdx + 1, n - minIdx);
        // Calculate the minimum deletions to remove the maxEle (from its closest end)
        int minDeletionsForMax = Math.min(maxIdx + 1, n - maxIdx);
        // Sum these two costs
        int ans3 = minDeletionsForMin + minDeletionsForMax;

        // Step 3: Return the minimum of the three strategies
        return Math.min(ans1, Math.min(ans2, ans3));
    }
}