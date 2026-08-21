class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>(); // {node, current_dist}
        q.offer(new int[]{0, 0});
        dist1[0] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0];
            int d = curr[1];

            for (int v : adj.get(u)) {
                if (d + 1 < dist1[v]) {
                    dist2[v] = dist1[v];
                    dist1[v] = d + 1;
                    q.offer(new int[]{v, d + 1});
                } else if (d + 1 > dist1[v] && d + 1 < dist2[v]) {
                    dist2[v] = d + 1;
                    q.offer(new int[]{v, d + 1});
                }
            }
        }

        return cal(dist2[n - 1], time, change);
    }

    public int cal(int k, int time, int change) {
        int totalTime = 0;
        for (int i = 0; i < k; i++) {
            totalTime += time;
            if (i != k - 1 && (totalTime / change) % 2 != 0) {
                totalTime += change - (totalTime % change);
            }
        }
        return totalTime;
    }
}