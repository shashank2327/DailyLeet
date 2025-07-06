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
class NodeInfo {
    int minNode;
    int maxNode;
    int sum;

    public NodeInfo(int minNode, int maxNode, int sum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
    }
}

class Solution {
    private int maxSum = 0; // Global variable to track max sum of any BST subtree

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private NodeInfo dfs(TreeNode root) {
        if (root == null) {
            return new NodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeInfo left = dfs(root.left);
        NodeInfo right = dfs(root.right);

        // Check if current subtree is a BST
        if (left.maxNode < root.val && root.val < right.minNode) {
            int currSum = root.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, currSum); // Update global max sum
            return new NodeInfo(
                Math.min(root.val, left.minNode),
                Math.max(root.val, right.maxNode),
                currSum
            );
        }

        // If not a BST, return invalid range and ignore sum
        return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}
