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
    public TreeNode searchBST(TreeNode root, int val) {
        return fun(root, val);
    }

    private TreeNode fun(TreeNode root, int val) {
        if (root == null) return root;

        if (root.val == val) {
            return root;
        }

        TreeNode node = new TreeNode(-1);
        if (root.val > val) {
            node = fun(root.left, val);
        } else {
            node = fun(root.right, val);
        }

        return node;
    }
}