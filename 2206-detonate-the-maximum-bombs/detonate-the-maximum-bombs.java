class Solution {

    private int bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        
        int sum  = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    sum++;
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return sum;
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    long x = Math.abs(bombs[i][0] - bombs[j][0]);
                    long y = Math.abs(bombs[i][1] - bombs[j][1]);
                    long r = bombs[i][2];
                    if ((x * x + y * y) <= r * r) {
                        adj.get(i).add(j);
                    }
                }
            }
        }

        boolean[] vis = new boolean[n];
        int ans = 1;

        for (int i = 0; i < n; i++) {
            vis = new boolean[n];
            if (!vis[i]) {
                int res = bfs(i, adj, vis);
                ans = Math.max(res, ans);
            }
        }
        
        return ans;
    }
}