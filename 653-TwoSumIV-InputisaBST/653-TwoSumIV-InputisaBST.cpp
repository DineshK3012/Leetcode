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
class BSTIterator{
private: 
    stack<TreeNode *> stk;
    bool reverse;

public: 
    BSTIterator(TreeNode* root, bool isReverse){
        reverse = isReverse;
        pushToStack(root);
    }

    void pushToStack(TreeNode* node){
        if(node == NULL)    return;

        stk.push(node);

        if(reverse){
            while(node->right != NULL){
                stk.push(node->right);
                node = node->right;
            }
        }else{
            while(node->left != NULL){
                stk.push(node->left);
                node = node->left;
            }
        }
    }
    
    int next(){
        TreeNode* nxt = stk.top();
        stk.pop();

        if(reverse){
            pushToStack(nxt->left);
        }else{
            pushToStack(nxt->right);
        }

        return nxt->val;
    }
};

class Solution {
public:
    bool findTarget(TreeNode* root, int k) {
        BSTIterator l(root, false);
        BSTIterator r(root, true);

        int i = l.next();
        int j = r.next();
        while(i != j){
            // cout<<i<<" "<<j<<endl;
            if((i + j) == k){
                return true;
            }else if((i + j) > k){
                j = r.next();
            }else{
                i = l.next();
            }
        }

        return false;
    }
};