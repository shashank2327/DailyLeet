class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int m = edges.length;
        int[][] dist = new int[n][n];
        for (int[] a : dist) {
            Arrays.fill(a, (int)1e9);
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for (int i = 0; i < n; i++) dist[i][i] = 0;


        // Flyod Warshal Algo.
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int cnt = n;
        int city = -1;

        for (int i = 0; i < n; i++) {
            int currCnt = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    currCnt++;
                }
            }

            if (currCnt <= cnt) {
                cnt = currCnt;
                city = i;
            }
        }

        return city;
    }
}