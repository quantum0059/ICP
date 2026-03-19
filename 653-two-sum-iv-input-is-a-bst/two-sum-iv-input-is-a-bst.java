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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return helper(root,  k, set);
    }

    static boolean helper(TreeNode root, int k, HashSet<Integer> set){
        if(root == null){
            return false;
        }
        int diff = k-root.val;
        if(set.contains(diff)){
            return true;
        }
        else{
            set.add(root.val);
        }
        boolean left = helper(root.left, k, set);
        boolean right = helper(root.right, k, set);

        return (left||right);
    }
}