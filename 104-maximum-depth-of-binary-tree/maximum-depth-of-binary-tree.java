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
    public int maxDepth(TreeNode root) {
        return f(root);
    }

    private int f(TreeNode root) {
        if (root == null) return 0;

        int rightDepth = 1 + f(root.right);
        int leftDepth = 1 + f(root.left);

        return Math.max(rightDepth, leftDepth);
    }
}