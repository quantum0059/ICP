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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        return helper(root, val);

        

    }
    static TreeNode helper(TreeNode root, int val){
        if(root == null){
            return null;
        }

        if(val<root.val){
            TreeNode left = helper(root.left, val);
            if(left == null){
                root.left = new TreeNode(val);
            }
        }
        else{
            TreeNode right =  helper(root.right, val);
            if(right==null){
                root.right = new TreeNode(val);
            }
        }

        return root;
    }
}