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
    private int prev = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root, 0);
        return root;
    }
     void helper(TreeNode root, int val){
        if(root == null){
            return ;
        }
        helper(root.right, val);
        prev+=root.val;
        root.val = prev;
        helper(root.left, root.val);
        

        return;
    }
}