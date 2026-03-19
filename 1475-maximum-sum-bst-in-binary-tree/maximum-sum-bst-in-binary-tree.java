class Solution {

    int maxSum = 0;

    static class NodeValue{
        int minNode, maxNode, sum;

        NodeValue(int minNode, int maxNode, int sum){
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.sum = sum;
        }
    }

    NodeValue helper(TreeNode root){
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        // valid BST
        if(left.maxNode < root.val && right.minNode > root.val){
            int sum = left.sum + right.sum + root.val;

            maxSum = Math.max(maxSum, sum);

            return new NodeValue(
                Math.min(root.val, left.minNode),
                Math.max(root.val, right.maxNode),
                sum
            );
        }

        // invalid BST
        return new NodeValue(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            0
        );
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
}