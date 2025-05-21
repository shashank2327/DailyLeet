/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        bfs(root, map);

        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        if (k == 0) {
            ans.add(target.val);
            return ans;
        }

        q.offer(target.val);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.remove();
                seen.add(curr);

                for (int val : map.get(curr)) {
                    if (!seen.contains(val)) {
                        q.offer(val);
                    }
                }
            }
            level++;
            if (level == k) {
                break;
            }
        }

        while (!q.isEmpty()) {
            ans.add(q.remove());
        }
        return ans;
    }

    // Making bi directed graph out of tree;
    private void bfs(TreeNode root, Map<Integer, List<Integer>> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                map.putIfAbsent(node.val, new ArrayList<>());

                if (node.left != null) {
                    map.putIfAbsent(node.left.val, new ArrayList<>());
                    map.get(node.val).add(node.left.val);
                    map.get(node.left.val).add(node.val);
                    q.offer(node.left);
                }

                if (node.right != null) {
                    map.putIfAbsent(node.right.val, new ArrayList<>());
                    map.get(node.val).add(node.right.val);
                    map.get(node.right.val).add(node.val);
                    q.offer(node.right);
                }
            }
        } 
    }
}