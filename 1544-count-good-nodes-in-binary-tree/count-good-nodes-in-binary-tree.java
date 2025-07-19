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
    public int goodNodes(TreeNode root) {
        return preorder(root, Integer.MIN_VALUE);
    }

    public int preorder(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        max = Math.max(max, root.val);

        if (max <= root.val) {
            return 1 + preorder(root.left, max) + preorder(root.right, max);
        } else {
            return preorder(root.right, max) + preorder(root.left, max);
        }
    }
}

/*
    preorder traversal -> root -> left -> right;
*/