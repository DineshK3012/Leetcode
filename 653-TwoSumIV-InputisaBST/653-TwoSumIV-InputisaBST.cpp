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
    bool helper(TreeNode * root, int target, unordered_set<int> & set){
        if(root == NULL)    return false;
        
        bool left = helper(root->left, target, set);
        if(left)    return true;
        
        if(set.find(target-root->val) != set.end()){
            return true;
        }
        set.insert(root->val);
        
        return helper(root->right, target, set);
    }

    bool findTarget(TreeNode* root, int k) {
        unordered_set<int> set;
        
        return helper(root, k, set);
    }
};