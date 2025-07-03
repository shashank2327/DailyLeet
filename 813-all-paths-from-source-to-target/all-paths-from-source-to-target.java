class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        allPaths(0, graph, graph.length, new boolean[graph.length], new ArrayList<>(), result);
        return result;
    }

    public void allPaths(int node, int[][] graph, int n, boolean[] vis, List<Integer> temp, List<List<Integer>> result) {

        // base case;
        // If i am on my last node, I found a path;
        if (node == n - 1) {
            temp.add(node);
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
        }

        vis[node] = true;
        temp.add(node);

        for (int i = 0; i < graph[node].length; i++) {
            if (!vis[graph[node][i]]) {
                allPaths(graph[node][i], graph, n, vis, temp, result);
            }
        }

        vis[node] = false;
        temp.remove(temp.size() - 1);
    }
}