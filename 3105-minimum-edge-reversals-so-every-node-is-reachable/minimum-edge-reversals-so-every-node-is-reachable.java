class Solution {
    int cnt = 0;
    public int[] minEdgeReversals(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(new int[]{v, 0});
            graph.get(v).add(new int[]{u, 1});
        }

        boolean[] vis = new boolean[n];
        dfs(graph, 0, vis);
        int[] conversion = new int[n];
        Arrays.fill(conversion, -1);
        conversion[0] = cnt;

        vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (int[] info : graph.get(node)) {
                    int adjNode = info[0];
                    int dir = info[1];
                    if (!vis[adjNode]) {

                        if (dir == 1) {
                            int cost = conversion[node] - 1;
                            conversion[adjNode] = cost;
                        } else {
                            int cost = conversion[node] + 1;
                            conversion[adjNode] = cost;
                        }

                        vis[adjNode] = true;
                        q.offer(adjNode);
                    }
                }
            }
        }

        return conversion;
    }

    public void dfs(List<List<int[]>> graph, int node, boolean[] vis) {
        vis[node] = true;
        for (int[] info : graph.get(node)) {
            int adjNode = info[0];
            int dir = info[1];
            if (!vis[adjNode]) {
                cnt += dir;
                dfs(graph, adjNode, vis);
            }
        }
    }
}