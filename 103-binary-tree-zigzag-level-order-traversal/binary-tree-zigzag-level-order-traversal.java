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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> l = new ArrayList<>();
        boolean flag = true;

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                if(!flag) Collections.reverse(l);
                list.add(new ArrayList<>(l));
                l = new ArrayList<>();

                if(q.isEmpty()){
                    break;
                }else{
                    q.offer(null);
                    flag = !flag;
                }

            }else{
                l.add(node.val);
                if(node.left != null){
                   q.offer(node.left);
                }
                if(node.right != null){
                  q.offer(node.right);
                }
            }
        }
        return list;
    }
}