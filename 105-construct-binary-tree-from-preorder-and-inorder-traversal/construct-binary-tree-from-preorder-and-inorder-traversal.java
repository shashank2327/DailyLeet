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
        Map<Integer, Integer> iotMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            iotMap.put(inorder[i], i);
        }

        return fun(preorder, iotMap, 0, 0, inorder.length - 1);
    }

    private TreeNode fun(
        int[] preorder, 
        Map<Integer, Integer> iotMap, 
        int rootIdx, 
        int left, 
        int right
    ) {
        
        TreeNode root = new TreeNode(preorder[rootIdx]);

        int mid = iotMap.get(preorder[rootIdx]);
        if (mid > left) {
            root.left = fun(preorder, iotMap, rootIdx + 1, left, mid - 1);
        }

        if (mid < right) {
            root.right = fun(preorder, iotMap, rootIdx + mid - left + 1, mid + 1, right);
        }

        return root;
    }
}