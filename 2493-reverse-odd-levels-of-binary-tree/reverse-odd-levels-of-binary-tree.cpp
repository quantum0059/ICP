/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    void traverse(TreeNode* leftNode, TreeNode* rightNode, int lvl) {
        
        if (!leftNode || !rightNode) {
            return;
        }

        
        if (lvl % 2 == 0) {
            std::swap(leftNode->val, rightNode->val);
        }

        traverse(leftNode->left, rightNode->right, lvl + 1);
        traverse(leftNode->right, rightNode->left, lvl + 1);
    }

    TreeNode* reverseOddLevels(TreeNode* root) {
        if (root) {
            traverse(root->left, root->right, 0);
        }
        return root;
    }
};