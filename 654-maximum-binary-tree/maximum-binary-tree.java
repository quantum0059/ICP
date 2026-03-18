/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    static TreeNode helper(int[] nums, int start, int end){
        if(start>end){
            return null;
        }

        int maxIdx = start;
        for(int i=start;i<=end;i++){
            if(nums[i]>nums[maxIdx]){
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIdx]);

        root.left = helper(nums, start, maxIdx-1);
        root.right = helper(nums, maxIdx+1, end);

        return root;
    }
}