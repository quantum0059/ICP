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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }

        TreeNode root  =  helper(map, preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }
    static TreeNode helper(HashMap<Integer, Integer> map, int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if(preStart>preEnd || inStart>inEnd) return null;

        TreeNode root = new TreeNode(preOrder[preStart]);

        int rootIdx = map.get(root.val);
        int endIdx = rootIdx-inStart;

        root.left = helper(map, preOrder, preStart+1, preStart+endIdx, inOrder, inStart, rootIdx-1);
        root.right = helper(map, preOrder, preStart+endIdx+1, preEnd, inOrder, rootIdx+1, inEnd);
        return root;
    }
}