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
    int idx;
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return build(preorder, Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, int bound) {
        if (idx == preorder.length || preorder[idx] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left = build(preorder, root.val);
        root.right = build(preorder, bound);

        return root;
    }
}