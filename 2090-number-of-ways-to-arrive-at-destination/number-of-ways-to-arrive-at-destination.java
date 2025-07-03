class Solution {
    private static final int MOD = (int)1e9 + 7;
    public int countPaths(int n, int[][] roads) {
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int timeTaken = road[2];

            graph.get(u).add(new int[] {v, timeTaken});
            graph.get(v).add(new int[] {u, timeTaken});
        }


        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);

        int[] ways = new int[n];


        // {node, timeTakenToReach}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        time[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] token = pq.poll();
            long timeTaken = token[0];
            int node = (int)token[1];

            for (int[] adj : graph.get(node)) {
                int adjNode = adj[0];
                int tm = adj[1];

                if (tm + timeTaken < time[adjNode]) {
                    time[adjNode] = tm + timeTaken;
                    ways[adjNode] = (ways[node]) % MOD;
                    pq.offer(new long[]{time[adjNode], adjNode});
                } else if (tm + timeTaken == time[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}