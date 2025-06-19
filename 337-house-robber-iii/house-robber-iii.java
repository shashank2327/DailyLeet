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
    public int rob(TreeNode root) {
        Map<TreeNode, int[]> map = new HashMap<>();
        return fun(root, 0, map);
    }
    private int fun(TreeNode root, int taken, Map<TreeNode, int[]> map) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root) && map.get(root)[taken] != -1) {
            return map.get(root)[taken];
        }

        int[] res = map.getOrDefault(root, new int[]{-1, -1});
        int ans = Integer.MIN_VALUE;

        // Two choices
        // 1. Taken the current root value;
        // 2. Do not take the current root value;
        // Whatever choice made, move to the children of root;

        if (taken == 0) {
            ans = Math.max(root.val + fun(root.left, 1, map) + fun(root.right, 1, map), ans);
        }
        ans = Math.max(fun(root.left, 0, map) + fun(root.right, 0, map), ans);

        res[taken] = ans;
        map.put(root, res);
        return ans;
    }
}