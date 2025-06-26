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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        pathSum(root);
        return max;
    }
    
    public int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = pathSum(root.left);
        if (leftSum < 0) leftSum = 0;
        int rightSum = pathSum(root.right);
        if (rightSum < 0) rightSum = 0;

        max = Math.max(max, leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }
}