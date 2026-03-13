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
        int col;
        Pair(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        q.add(new Pair(root, 0, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int row = p.row;
            int col = p.col;
            map.putIfAbsent(col,new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).add(node.val);

            if(node.left!=null){
                q.offer(new Pair(node.left, row+1, col-1));
            }
            if(node.right != null){
               q.offer(new Pair(node.right, row+1, col+1));   
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> rows: map.values()){
            List<Integer> l = new ArrayList<>();
            for(PriorityQueue<Integer> pq : rows.values()){
                while(!pq.isEmpty()){
                    l.add(pq.poll());
                }
            }
            list.add(new ArrayList<>(l));
        }

        return list;
    }
}