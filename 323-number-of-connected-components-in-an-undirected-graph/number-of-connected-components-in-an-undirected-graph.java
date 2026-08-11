class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                cnt++;
                dfs(adj, n, vis, i);
            }
        }

        return cnt;
    }

    public void dfs(List<List<Integer>> adj, int n, int[] vis, int node) {
        vis[node] = 1;

        for (int neighbour: adj.get(node)) {
            if (vis[neighbour] == 0) {
                dfs(adj, n, vis, neighbour);
            }
        }
    }
}