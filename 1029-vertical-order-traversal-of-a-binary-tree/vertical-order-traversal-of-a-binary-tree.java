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
class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // col -> level -> values;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple it = q.poll();
            TreeNode n = it.node;
            int r = it.row;
            int c = it.col;

            if (!map.containsKey(c)) {
                map.put(c, new TreeMap<>());
            }
            if (!map.get(c).containsKey(r)) {
                map.get(c).put(r, new PriorityQueue<>());
            }
            map.get(c).get(r).offer(n.val);

            if (n.left != null) {
                q.offer(new Tuple(n.left, r + 1, c - 1));
            }

            if (n.right != null) {
                q.offer(new Tuple(n.right, r + 1, c + 1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> nd : ys.values()) {
                while (!nd.isEmpty()) {
                    res.get(res.size() - 1).add(nd.poll());
                }
            }
        }

        return res;
    }
}