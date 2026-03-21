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
    public void helper(TreeNode root,int[] prev,int[] min){
        if(root==null) return;
        helper(root.left,prev,min);
        if(prev[0]!=(int)(1e9)) min[0] = Math.min(min[0],root.val-prev[0]);
        prev[0]=root.val;
        helper(root.right,prev,min);
    }
    public int minDiffInBST(TreeNode root) {
        int[] prev = new int[1];
        prev[0]= (int)(1e9);
        int[] min = new int[1];
        min[0] = (int)(1e9);
        helper(root,prev,min);
        return min[0];
    }
}