/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static void parent_Tracker(TreeNode root, Map<TreeNode, TreeNode> map){
        Queue<TreeNode> q= new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                q.add(curr.left);
                map.put(curr.left, curr);
            }
            if(curr.right!=null){
                q.add(curr.right);
                map.put(curr.right, curr);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent_Tracker(root, parent);
        Map<TreeNode, Boolean> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        map.put(target, true);
        int currLvl = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(currLvl == k) break;
            currLvl++;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left!=null && map.get(node.left) == null){
                    q.add(node.left);
                    map.put(node.left, true);
                }
                if(node.right!=null && map.get(node.right) == null){
                    q.add(node.right);
                    map.put(node.right, true);
                }
                if(parent.get(node) != null && map.get(parent.get(node))==null){
                    q.add(parent.get(node));
                    map.put(parent.get(node), true);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }

        return list;
    }
}