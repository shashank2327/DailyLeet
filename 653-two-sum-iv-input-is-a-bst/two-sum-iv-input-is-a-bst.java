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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        TreeNode start = root;
        TreeNode end = root;

        while (start.left != null) {
            start = start.left;
        }
        while (end.right != null) {
            end = end.right;
        }

        while (start != end) {
            int val = start.val + end.val;
            if (val > k) {
                end = predecessor(root, end);
            } else if (val < k) {
                start = successor(root, start);
            } else {
                return true;
            }
        }

        return false;
    }

    private TreeNode predecessor(TreeNode root, TreeNode node) {
        TreeNode temp = root;
        TreeNode res = null;

        while (temp != null) {
            if (temp.val < node.val) {
                res = temp;
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return res;
    }

    private TreeNode successor(TreeNode root, TreeNode node) {
        TreeNode temp = root;
        TreeNode res = null;

        while (temp != null) {
            if (temp.val > node.val) {
                res = temp;
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        return res;
    }
}