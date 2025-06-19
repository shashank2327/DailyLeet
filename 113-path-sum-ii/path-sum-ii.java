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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        fun(root, res, new ArrayList<>(), targetSum, 0);
        return res;
    }

    private void fun(
        TreeNode root,
        List<List<Integer>> res,
        List<Integer> temp,
        int targetSum,
        int currSum
    ) 
    {
        if (root == null) {
            return;
        }

        // base case;
        if (root.left == null && root.right == null) {
            if (targetSum == currSum + root.val) {
                temp.add(root.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }


        // I have two paths to go
        // Either left or right;

        temp.add(root.val);

        fun(root.left, res, temp, targetSum, currSum + root.val);
        fun(root.right, res, temp, targetSum, currSum + root.val);

        temp.remove(temp.size() - 1);
    }
}