class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; // number of nodes;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !dfs(i, 0, color, graph)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;

        for (int i = 0; i < graph[node].length; i++) {
            if (color[graph[node][i]] == -1 && !dfs(graph[node][i], 1 - col,    color, graph)) {
                return false;
            } else if (color[graph[node][i]] == col) return false;
        }

        return true;
    }
}