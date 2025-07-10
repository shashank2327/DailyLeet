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
    int steps;
    public int distributeCoins(TreeNode root) {
        steps = 0;
        postorder(root);
        return steps;
    }

    public int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftRequired = postorder(root.left);
        int rightRequired = postorder(root.right);

        steps += Math.abs(leftRequired) + Math.abs(rightRequired);

        return (root.val - 1) + leftRequired + rightRequired;
    }
}