class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, graph) == false) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;
        for (int i = 0; i < graph[node].length; i++) {
            if (color[graph[node][i]] == -1) {
                if (dfs(graph[node][i], 1- col, color, graph) == false) {
                    return false;
                }
            }  else if (color[graph[node][i]] == col) {
                    return false;
            }
        }
        return true;
    }
}