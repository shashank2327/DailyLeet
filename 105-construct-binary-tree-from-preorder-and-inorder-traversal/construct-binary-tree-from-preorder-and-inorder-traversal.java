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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return fun(preorder, map, 0, n - 1);
    }


    private int preorderIdx = 0;
    private TreeNode fun(int[] preorder, Map<Integer, Integer> map, int left, int right) {
        if(left>right) return null;
        int pval = preorder[preorderIdx];
        int inorderIdx = map.get(pval);

        TreeNode root = new TreeNode(pval);
        preorderIdx++;
        root.left = fun(preorder, map, left, inorderIdx-1);
        root.right = fun(preorder, map, inorderIdx+1, right);
        return root;
    }
}