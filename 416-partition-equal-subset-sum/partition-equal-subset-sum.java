class Solution {
    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        memo = new Boolean[nums.length][target + 1];

        return canFindSubsetSum(nums, 0, target);
    }

    private boolean canFindSubsetSum(int[] nums, int idx, int remainingTarget) {
        // Base cases
        if (remainingTarget == 0) { 
            return true;
        }
        if (idx == nums.length || remainingTarget < 0) {
            return false;
        }

        if (memo[idx][remainingTarget] != null) {
            return memo[idx][remainingTarget];
        }

        boolean include = canFindSubsetSum(nums, idx + 1, remainingTarget - nums[idx]);

        boolean exclude = canFindSubsetSum(nums, idx + 1, remainingTarget);

        return memo[idx][remainingTarget] = include || exclude;
    }
}