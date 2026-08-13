class Solution {
    public int magnificentSets(int n, int[][] edges) {

        /* Graph Formation */
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            int u = edge[0] - 1;
            int v = edge[1]  - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        /* Bipartite Checking */
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !bpt(adj, i, 0, color)) return -1;
        }

        /* Calculate maximum depth from each node */
        int[] depth = new int[n];
        for (int i = 0; i < n; i++) {
            depth[i] = maxdepth(adj, i, n);
        }

        
        /* Calculate maximum depth for each component */

        int res = 0;
        int[] vis = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                res += max_comp(adj, i, n, depth, vis);
            }
        }

        return res;

    }

    public boolean bpt(
        List<List<Integer>> adj,
        int node,
        int col,
        int[] color
    ) {
        color[node] = col;

        for (int nbr : adj.get(node)) {
            if (color[nbr] == col) return false;

            if (color[nbr] == -1 && !bpt(adj, nbr, 1 - col, color)) return false;
        }

        return true;
    }


    public int maxdepth(
        List<List<Integer>> adj,
        int src,
        int n
    ) {
        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(src);
        vis[src] = 1;
        int level = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int nd = q.poll();
                for (int nbr : adj.get(nd)) {
                    if (vis[nbr] == 0) {
                        vis[nbr] = 1;
                        q.offer(nbr);
                    }
                }
            }
            level++;
        }

        return level;
    }

    public int max_comp(
        List<List<Integer>> adj,
        int nd,
        int n,
        int[] depth,
        int[] vis
    ) {
        int maxi_grp = depth[nd];
        vis[nd] = 1;

        for (int nbr: adj.get(nd)) {
            if (vis[nbr] == 1) continue;

            maxi_grp = Math.max(maxi_grp, max_comp(adj, nbr, n, depth, vis));
        }

        return maxi_grp;
    }
}

/*
    Solve Each component independently;
    But How will you get each unique component?

    If you get the component ---->
    Then what steps will you do next:

    For each node do the bfs, also keeeping track of bipartite condition;
    get the maximum depth;
*/