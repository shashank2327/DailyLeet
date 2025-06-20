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

 class Pair {
    TreeNode node;
    int idx;

    public Pair(TreeNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }

 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            int first = 0, last = 0;
            int minIdx = q.peek().idx;

            for (int i = 0; i < sz; i++) {
                Pair it = q.poll();
                TreeNode node = it.node;
                int currIdx = it.idx - minIdx;
                if (i == 0) first = currIdx;
                if (i == sz - 1) last = currIdx;

                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * currIdx));
                }

                if (it.node.right != null) {
                    q.add(new Pair(node.right, 2 * currIdx + 1));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}