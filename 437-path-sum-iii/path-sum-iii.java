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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        helper(root, 0, targetSum, map);
        return (int)count;
    }

    long count = 0;
    public void helper(TreeNode root, long currSum, long targetSum, Map<Long, Long> map) {
        if (root == null) {
            return;
        }

        currSum += root.val;

        if (map.containsKey(currSum - targetSum)) {
            count += map.get(currSum - targetSum);
        }

        map.put(currSum, map.getOrDefault(currSum, 0L) + 1);

        helper(root.left, currSum, targetSum, map);
        helper(root.right, currSum, targetSum, map);

        // backtracking;
        map.put(currSum, map.get(currSum) - 1);
    }
}