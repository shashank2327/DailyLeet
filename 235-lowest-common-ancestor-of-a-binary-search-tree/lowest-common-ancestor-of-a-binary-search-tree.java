/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return helper(root, q, p);
        }
        return helper(root, p, q);
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }

        if (root.val > p.val && root.val < q.val) {
            return root;
        }

        if (root.val > p.val && root.val > q.val) {
            return helper(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return helper(root.right, p, q);
        }
        return null;
    }
}

// LCA = x;
//  p <= x <= q;