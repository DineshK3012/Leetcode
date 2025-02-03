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
    private TreeNode helper(int[] postorder, int[] inorder, int ps, int pe, int is, int ie){
        if(ps > pe || is > ie){
            return null;
        }

        if(ps == pe){
            return new TreeNode(postorder[ps]);
        }

        TreeNode root = new TreeNode(postorder[pe]);
        int rootIndex = is;
        while(inorder[rootIndex] != root.val){
            rootIndex++;
        }

        int left_length = rootIndex - is;

        root.left = helper(postorder, inorder, ps, ps + left_length - 1, is, rootIndex - 1);
        root.right = helper(postorder, inorder, ps + left_length, pe-1, rootIndex + 1, ie);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }
}