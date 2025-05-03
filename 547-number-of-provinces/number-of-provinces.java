class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) continue;
                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(i, adj, vis);
            }
        }

        return cnt;

    }

    private void bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : adj.get(node))  {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }

    private void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;

        for (int it : adj.get(src)) {
            if (!vis[it]) {
                dfs(it, adj, vis);
            }
        }
    }
}