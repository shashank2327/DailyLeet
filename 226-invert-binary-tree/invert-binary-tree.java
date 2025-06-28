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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                TreeNode left = null;
                TreeNode right = null;
                if (node.left != null) {
                    q.offer(node.left);
                    left = node.left;
                }
                if (node.right != null) {
                    q.offer(node.right);
                    right = node.right;
                }

                node.left = right;
                node.right = left;
            }
        }

        return root;
    }
}

// every node child should reverse;
// left child becomes right and right child becomes left;