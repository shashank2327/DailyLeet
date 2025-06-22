class Solution {

    public int count;

    public int minIncrease(int n, int[][] edges, int[] cost) {
        count = 0;

        List<List<Integer>> adj = new ArrayList<>(); // graph or Adjancency List;
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(0, -1, adj, cost);
        return count;
    }


    public long dfs(int node, int parent, List<List<Integer>> adj, int[] cost) {
        // if we encounter a leaf node;
        if (adj.get(node).size() == 1 && parent != -1) {
            return cost[node];
        }

        long maxSum = 0;
        List<Long> childPaths = new ArrayList<>();

        for (int child : adj.get(node)) {
            if (child == parent) continue;

            long childCost = dfs(child, node, adj, cost);
            childPaths.add(childCost);
            maxSum = Math.max(maxSum, childCost);
        }

        for (long childCost : childPaths) {
            if (childCost < maxSum) count++;
        }

        return cost[node] + maxSum;
    }
}