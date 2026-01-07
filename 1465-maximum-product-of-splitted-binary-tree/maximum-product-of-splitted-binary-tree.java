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

    private final int MOD = 1_000_000_007;
    private long ans = 0;

    public int maxProduct(TreeNode root) {
        long totalSum = findSum(root);
        subtreeSum(root, totalSum);
        return (int)(ans % MOD);
    }

    private long subtreeSum(TreeNode root, long totalSum) {
        if (root == null) {
            return 0;
        }

        long leftSum = subtreeSum(root.left, totalSum);
        long rightSum = subtreeSum(root.right, totalSum);

        long val1 = leftSum * (totalSum - leftSum);
        long val2 = rightSum * (totalSum - rightSum);

        ans = (long)Math.max(ans, Math.max(val1, val2));

        return root.val + leftSum + rightSum;
    }

    public long findSum(TreeNode root) {
        long totalSum = 0;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode it = q.poll();
            int value = it.val;
            totalSum += value;

            if (it.left != null) {
                q.offer(it.left);
            }

            if (it.right != null) {
                q.offer(it.right);
            }
        }

        return totalSum;
    }
}

/*
    for each node
    what is the sum on left and what is the sum on right.

    lets call it sleft and sright

    I will also have a totalSum;

    for a particular node If I am removing the left edge;

    two subtrees will be created

    sumLeft;


    remaining = totalSum - sumLeft;

*/