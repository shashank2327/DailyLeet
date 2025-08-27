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
    int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        maxDiff(root);
        return max;
    }

    private int[] maxDiff(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[]{root.val, root.val};
        }
        int maxi = root.val;
        int mini = root.val;

        if (root.left != null) {
            int[] values = maxDiff(root.left);
            max = Math.max(max, Math.max(Math.abs(root.val - values[0]), Math.abs(root.val - values[1])));
            maxi = Math.max(maxi, values[1]);
            mini = Math.min(mini, values[0]);
        }

        if (root.right != null) {
            int[] values = maxDiff(root.right);
            max = Math.max(max, Math.max(Math.abs(root.val - values[0]), Math.abs(root.val - values[1])));
            maxi = Math.max(maxi, values[1]);
            mini = Math.min(mini, values[0]);
        }

        return new int[]{mini, maxi};
    }
}

/*
    for the left part get the min and max;
    for the right part get the min and max;
*/