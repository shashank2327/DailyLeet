class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int m = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 1) continue;

            int[] countEdgeVertex = new int[2]; // will contain number of edges and vertex of a component;
            dfs(i, adj, vis, countEdgeVertex);

            if (countEdgeVertex[0] * (countEdgeVertex[0] - 1) == countEdgeVertex[1]) {
                ans++;
            }
        }

        return ans;
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] comp) {
        vis[node] = 1;
        comp[0]++;
        comp[1] += adj.get(node).size();

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs (it, adj, vis, comp);
            }
        }
    }
}