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
    class info{
        long max;
        long min;
        boolean isBST;

        public info(long mx, long mn, boolean isBST){
            this.max = mx;
            this.min = mn;
            this.isBST = isBST;
        }
    }

    public info helper(TreeNode root){
        if(root == null){
            return new info(Long.MIN_VALUE, Long.MAX_VALUE, true);
        }

        if(root.left == null && root.right == null){
            return new info(root.val, root.val, true);
        }

        info left = helper(root.left);
        info right = helper(root.right);

        long min = Math.min(root.val, left.min);
        long max = Math.max(root.val, right.max);
        boolean isBST = true;
        if(!left.isBST || !right.isBST || left.max >= root.val || right.min <= root.val){
            isBST = false;
        }

        return new info(max, min, isBST);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }
}