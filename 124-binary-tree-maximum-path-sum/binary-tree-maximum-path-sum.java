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
    public int maxPathSum(TreeNode root) {
        int[] maxVal = new int[1];
        maxVal[0] = Integer.MIN_VALUE;
        maxPath(root, maxVal);
        return maxVal[0];
    }

    private int maxPath(TreeNode node, int[] maxVal) {
        if (node == null) {
            return 0;
        }

        int left = maxPath(node.left, maxVal);
        if (left < 0) left = 0;

        int right = maxPath(node.right, maxVal);
        if (right < 0) right = 0;

        maxVal[0] = Math.max(maxVal[0], left + right + node.val);

        return Math.max(left, right) + node.val;
    }
}