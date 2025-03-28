class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int m = edges.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] vis = new int[n];
        dfs(source, adjList, vis);
        
        return vis[destination] == 1;
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            if (vis[adj.get(node).get(i)] == 0) {
                dfs(adj.get(node).get(i), adj, vis);
            }
        }
    }
}