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
class BSTIterator {
    ArrayList<Integer> nodes;
    int i;

    private void inorder(TreeNode root, ArrayList<Integer> nodes){
        if(root == null)    return;

        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }

    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        i = 0;

        inorder(root, nodes);
    }
    
    public int next() {
        if(i < nodes.size()){
            return nodes.get(i++);
        }

        return -1;
    }
    
    public boolean hasNext() {
        if(i < nodes.size()){
            return true;
        }

        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */