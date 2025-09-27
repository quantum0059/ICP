class Solution {
    public int first(int[] nums, int t) {
        int s = 0, e = nums.length - 1, ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == t) {
                ans = mid;
                e = mid - 1;
            } else if (nums[mid] < t) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    public int last(int[] nums, int t) {
        int s = 0, e = nums.length - 1, ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == t) {
                ans = mid;
                s = mid + 1; 
            } else if (nums[mid] < t) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[] { first(nums, target), last(nums, target) };
    }
}
