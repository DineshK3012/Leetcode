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
    TreeNode* recoverFromPreorder(string traversal) {
        stack<pair<TreeNode*, int>> stk;
        int root = 0;
        int i = 0;
        while(i < traversal.length() && traversal[i] != '-'){
            root = root * 10 + (traversal[i] - '0');
            i++;
        }

        TreeNode* rt = new TreeNode(root);
        stk.push({rt, 0});
        int prev = 0;
        while(i < traversal.length()){
            int depth = 0;
            while(traversal[i] == '-'){
                depth++;
                i++;
            }

            int node = 0;
            while(i < traversal.length() && traversal[i] != '-'){
                node = node*10 + (traversal[i] - '0');
                i++;
            }

            TreeNode* nn = new TreeNode(node);

            pair<TreeNode*, int> p = stk.top();
            while(depth <= p.second){
                stk.pop();
                p = stk.top();
            }

            // cout<<node<<" "<<depth<<" "<<p.second<<endl;

            if(p.first->left == NULL){
                p.first->left = nn;
            }else{
                p.first->right = nn;
            }
            stk.push({nn, depth});
        }

        return rt;
    }
};