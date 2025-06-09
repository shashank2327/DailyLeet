class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] outdegree = new int[n];
        boolean[][] connected = new boolean[n][n];
        int m = roads.length;
        for (int i = 0; i < m; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            connected[u][v] = true;
            connected[v][u] = true;
            outdegree[u]++;
            outdegree[v]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (connected[i][j]) {
                    ans = Math.max(ans, outdegree[i] + outdegree[j] - 1);
                } else {
                    ans = Math.max(ans, outdegree[i] + outdegree[j]);
                }
            }
        }

        return ans;
    }
}