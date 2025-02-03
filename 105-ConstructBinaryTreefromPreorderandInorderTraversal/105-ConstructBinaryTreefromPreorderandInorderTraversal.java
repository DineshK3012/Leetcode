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
    private TreeNode helper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie){
        if(ps > pe || is > ie){
            return null;
        }

        if(ps == pe){
            return new TreeNode(preorder[ps]);
        }

        TreeNode root = new TreeNode(preorder[ps]);
        int rootIndex = is;
        while(inorder[rootIndex] != root.val){
            rootIndex++;
        }

        int left_length = rootIndex - is;

        root.left = helper(preorder, inorder, ps + 1, ps + left_length, is, rootIndex - 1);
        root.right = helper(preorder, inorder, ps + left_length + 1, pe, rootIndex + 1, ie);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}