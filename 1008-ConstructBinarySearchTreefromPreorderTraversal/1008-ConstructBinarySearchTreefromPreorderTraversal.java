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
    public TreeNode helper(int[] preorder, int i, int j){
        if(i > j){
            return null;
        }

        if(i == j){
            return new TreeNode(preorder[i]);
        }

        TreeNode root = new TreeNode(preorder[i]);
        int x = i+1;
        while(x <= j && root.val > preorder[x]){
            x++;
        }

        root.left = helper(preorder, i+1, x-1);
        root.right = helper(preorder, x, j);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }
}