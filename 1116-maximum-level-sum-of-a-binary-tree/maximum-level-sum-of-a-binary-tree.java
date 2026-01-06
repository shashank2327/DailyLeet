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
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int res = -1;
        int level = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int sum = 0;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode it = q.poll();
                sum += it.val;
                if (it.left != null) {
                    q.add(it.left);
                }
                if (it.right != null) {
                    q.add(it.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                res = level;
            }

            level++;
        }

        return res;
    }
}