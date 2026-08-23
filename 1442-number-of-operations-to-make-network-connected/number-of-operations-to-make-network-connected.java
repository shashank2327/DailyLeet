class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] connection: connections) {
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                cnt++;
                dfs(adj, vis, i);
            }
        }

        return cnt - 1;
    }

    public void dfs(List<List<Integer>> adj, int[] vis,  int nd) {
        vis[nd] = 1;

        for (int nbr: adj.get(nd)) {
            if (vis[nbr] == 0) {
                dfs(adj, vis, nbr);
            }
        }
    }
}