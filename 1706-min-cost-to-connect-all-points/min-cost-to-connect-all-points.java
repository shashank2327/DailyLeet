class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int edgeWt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, edgeWt});
            }
        }

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int edgeWt = edge[2];

            graph.get(u).add(new int[]{v, edgeWt});
            graph.get(v).add(new int[]{u, edgeWt});
        }

        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{0, 0});
        int result = 0;
        while (!queue.isEmpty()) {
            int[] token = queue.poll();
            int node = token[0];
            int wt = token[1];  // weight;

            if (vis[node]) continue;

            vis[node] = true;
            result += wt;

            for (int[] adj : graph.get(node)) {
                int adjNode = adj[0];
                int edgeWt = adj[1];

                if (!vis[adjNode]) {
                    queue.offer(new int[]{adjNode, edgeWt});
                }
            }
        }

        return result;
    }
}

// number of points = 1000;

// [  0      ,  1   ,    2   ]
// [[3, 12], [-2, 5], [-4, 1]];

// [0, 1, 12];
// [0, 2, 18];
// [1, 2, 6];