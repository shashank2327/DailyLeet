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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        paths(root, "", result);
        return result;
    }

    public void paths(TreeNode root, String s, List<String> result) {
        if (root.left == null && root.right == null) {
            s = s + root.val;
            result.add(s);
            return;
        }

        if (root.left != null) {
            paths(root.left, s + root.val + "->", result);
        }
        if (root.right != null) {
            paths(root.right, s + root.val + "->", result);
        }
    }
}