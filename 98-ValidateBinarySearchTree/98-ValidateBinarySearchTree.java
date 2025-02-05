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
    class NodeInfo{
        boolean isBST;
        long max;
        long min;

        public NodeInfo(long mx, long mn, boolean isBst){
            this.max = mx;
            this.min = mn;
            this.isBST = isBst;
        }
    }

    public NodeInfo helper(TreeNode root){
        if(root == null){
            return new NodeInfo(Long.MIN_VALUE, Long.MAX_VALUE, true);
        }

        if(root.left == null && root.right == null){
            return new NodeInfo(root.val, root.val, true);
        }

        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);

        long max = Math.max(root.val, Math.max(left.max, right.max));
        long min = Math.min(root.val, Math.min(left.min, right.min));
        boolean isBST = true;

        if(root.val <= left.max || root.val >= right.min || !left.isBST || !right.isBST){
            isBST = false;
        }

        return new NodeInfo(max, min, isBST);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }
}