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
    public int minDiffInBST(TreeNode root) {
       List<Integer> list = new ArrayList<>();
       helper(root, list);

       int min = Integer.MAX_VALUE;
       if(list.size() == 1) return list.get(0);
       if(list.size() == 2) return list.get(1)-list.get(0);
       for(int i=1;i<list.size()-1;i++){
          int prev = list.get(i)-list.get(i-1);
          int next = list.get(i+1)-list.get(i);

          int m = Math.min(prev, next);
          min = Math.min(min, m);
       }
       return min;
    }
    static void helper(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}