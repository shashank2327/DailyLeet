class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (checkBFS(i, V, graph, color) == false) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean checkBFS(int start, int V, int[][] graph, int[] color) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int i = 0; i < graph[node].length; i++) {
                if (color[graph[node][i]] == -1) {
                    color[graph[node][i]] = color[node] ^ 1;
                    q.add(graph[node][i]);
                } else if (color[graph[node][i]] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}