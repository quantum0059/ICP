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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(map, postorder, 0, postorder.length - 1,
                      inorder, 0, inorder.length - 1);
    }

    static TreeNode helper(HashMap<Integer, Integer> map,
                           int[] postOrder, int postStart, int postEnd,
                           int[] inOrder, int inStart, int inEnd){

        if(postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postOrder[postEnd]);

        int rootIdx = map.get(root.val);
        int leftSize = rootIdx - inStart;

        root.left = helper(map,
                postOrder, postStart, postStart + leftSize - 1,
                inOrder, inStart, rootIdx - 1);

        root.right = helper(map,
                postOrder, postStart + leftSize, postEnd - 1,
                inOrder, rootIdx + 1, inEnd);

        return root;
    }
}