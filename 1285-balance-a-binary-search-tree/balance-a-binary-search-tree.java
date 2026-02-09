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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();

        inorderTraversal(root, inOrder);

        return creatingBST(inOrder, 0, inOrder.size()-1);
    }

    static void inorderTraversal(TreeNode root, List<Integer> order){
        if(root == null){
            return;
        }
        inorderTraversal(root.left, order);
        order.add(root.val);
        inorderTraversal(root.right, order);

    }

    static TreeNode creatingBST(List<Integer> order, int start, int end){
        if(start > end) return null;

        int mid = start+(end-start)/2;

        TreeNode leftSubtree = creatingBST(order, start, mid-1);
        TreeNode rightSubtree = creatingBST(order, mid+1, end);

        TreeNode node = new TreeNode(order.get(mid), leftSubtree, rightSubtree);

        return node;
    }
}