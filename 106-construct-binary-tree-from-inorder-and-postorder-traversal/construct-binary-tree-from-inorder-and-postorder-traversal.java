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

    private int postIdx = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            postIdx++;
            map.put(inorder[i], i);
        }
        postIdx--; // should be n - 1;
        return fun(postorder, map, 0, n - 1);
    }

    private TreeNode fun(int[] postorder, Map<Integer, Integer> map, int left, int right) {
        if (left > right) return null;

        int mid = map.get(postorder[postIdx]);

        TreeNode root = new TreeNode(postorder[postIdx]);
        postIdx--;

        root.right = fun(postorder, map, mid + 1, right);
        root.left = fun(postorder, map, left, mid - 1);

        return root;
    }
}