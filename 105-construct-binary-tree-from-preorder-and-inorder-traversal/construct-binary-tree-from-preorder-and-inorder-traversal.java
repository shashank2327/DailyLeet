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
        int n = inorder.length;
        Map<Integer, Integer> nodeToIdx = new HashMap<>(); // for inorder array
        for (int i = 0; i < n; i++) {
            nodeToIdx.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, nodeToIdx, 0, n - 1);
    }
    int preorderIdx = 0;
    private TreeNode buildTree(
        int[] preorder,
        int[] inorder,
        Map<Integer, Integer> nodeToIdx,
        int l,
        int r
    ) 
    {
        if (l > r) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderIdx++]);
        int inorderIdx = nodeToIdx.get(root.val);

        root.left = buildTree(preorder, inorder, nodeToIdx, l, inorderIdx - 1);
        root.right = buildTree(preorder, inorder, nodeToIdx, inorderIdx + 1, r);

        return root;
    }
}

// p -> 3, 9, 20, 15, 7   root -> left -> right
// i -> 9, 3, 15, 20, 7   left -> root -> right
