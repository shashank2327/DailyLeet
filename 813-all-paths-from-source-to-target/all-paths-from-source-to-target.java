class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();
        dfs(graph, 0, vis, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[][] graph, int node, boolean[] vis, List<Integer> path, List<List<Integer>> result) {
        // base case
        if (node == graph.length - 1) {
            path.add(node);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }

        vis[node] = true;
        path.add(node);

        for (int i = 0; i < graph[node].length; i++) {
            if (!vis[graph[node][i]]) {
                dfs(graph, graph[node][i], vis, path, result);
            }
        }

        vis[node] = false;
        path.remove(path.size() - 1);
    }
}