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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode node = findRed(root, x);
        int lc = Cnt(node.left);
        int rc = Cnt(node.right);
        int p = n-lc-rc-1;
        return Math.max(lc, Math.max(rc, p))>n/2;
    }
    TreeNode findRed(TreeNode root, int x){
        if(root == null) return null;
        if(root.val == x) return root;

        TreeNode left = findRed(root.left, x);
        TreeNode right = findRed(root.right, x);

        return left == null ? right:left;
    }
    int Cnt(TreeNode root){
        if(root == null) return 0;

        return Cnt(root.left)+Cnt(root.right)+1;
    }
}