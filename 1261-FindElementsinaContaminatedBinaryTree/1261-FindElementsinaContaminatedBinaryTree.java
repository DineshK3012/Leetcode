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
class FindElements {
    TreeNode root;

    private void recoverTree(TreeNode root, int val){
        if(root == null)    return;

        root.val = val;
        recoverTree(root.left, 2*val + 1);
        recoverTree(root.right, 2*val + 2);
    }

    public FindElements(TreeNode root) {
        this.root = root;

        recoverTree(root, 0);
    }
    
    public boolean find(int target) {
        Stack<Integer> stk = new Stack<>();
        stk.push(target);

        while(target != 0){
            stk.push((target - 1) / 2);
            target = (target - 1) / 2;
        }

        return isPresent(root, stk);
    }

    private boolean isPresent(TreeNode root, Stack<Integer> stk){
        if(root == null){
            return stk.isEmpty();
        }

        if(root.val == stk.peek()){
            stk.pop();
        }

        if(stk.isEmpty()){
            return true;
        }

        if(root.left != null && root.left.val == stk.peek()){
            return isPresent(root.left, stk);
        }

        if(root.right != null && root.right.val == stk.peek()){
            return isPresent(root.right, stk);
        }

        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */