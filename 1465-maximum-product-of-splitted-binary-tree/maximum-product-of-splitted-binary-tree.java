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
    static final int MOD = 1000000007;
     ArrayList<Long> list = new ArrayList<>();
    public long postOrderTraversal(TreeNode root){
        if(root == null){
            return 0;
        }

        long left = postOrderTraversal(root.left);
        long right = postOrderTraversal(root.right);
        long subSum = left+right+root.val;
        list.add(subSum);

        return subSum;
    }
    public int maxProduct(TreeNode root) {
        long subtreeSum = postOrderTraversal(root);
        long maxproduct = 0;
        for(long i: list){
             maxproduct = Math.max(maxproduct, i*(subtreeSum-i));
        }

        return (int)(maxproduct % MOD);
    }
}