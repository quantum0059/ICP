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
    static class Pair{
        TreeNode node;
        int row;

        Pair(TreeNode node, int col){
            this.node = node;
            this.row = col;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        // code here
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();

        q.offer(new Pair(root,0));

        while(!q.isEmpty()){

            Pair p = q.poll();
            TreeNode node = p.node;
            int row = p.row;

            map.put(row,node.val);

            if(node.left != null){
                q.offer(new Pair(node.left, row+1));
            }

            if(node.right != null){
                q.offer(new Pair(node.right,row+1));
            }
        }

        list.addAll(map.values());

        return list;
    }
}
    