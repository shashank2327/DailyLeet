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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        TreeNode temp = root;

        if (temp.val == key) {
            return helper(temp);
        }
        // searching for the node;
        while (temp != null) {
            if (temp.val > key) {
                if (temp.left != null && temp.left.val == key) {
                    temp.left = helper(temp.left);
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right != null && temp.right.val == key) {
                    temp.right = helper(temp.right);
                } else {
                    temp = temp.right;
                }
            }
        }

        return root;
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode rightChild = root.right;
            TreeNode temp = rightChild;
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = root.left;
            return rightChild;
        }
    }
}