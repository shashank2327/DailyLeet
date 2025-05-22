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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(preorder[i], i);
            for (int j = i + 1; j < n; j++) {
                if (preorder[j] < preorder[i]) {
                    map.put(preorder[i], j);
                }
            }
        }
        return fun(preorder, map, 0, n - 1);
    }

    private int proIdx = 0;

    private TreeNode fun(int[] preorder, Map<Integer, Integer> map, int left, int right) {
        if (left > right) return null;

        int val = preorder[proIdx];
        TreeNode root = new TreeNode(val);
        int idx = map.get(val);
        proIdx++;

        root.left = fun(preorder, map, left + 1, idx);
        root.right = fun(preorder, map, idx + 1, right);

        return root;
    }
}