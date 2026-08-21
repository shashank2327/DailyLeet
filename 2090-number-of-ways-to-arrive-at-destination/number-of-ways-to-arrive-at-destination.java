class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int countPaths(int n, int[][] roads) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road: roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new int[] {v, time});
            adj.get(v).add(new int[] {u, time});
        }

        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);

        int[] ways = new int[n];

        // {node, timeTakenSoFar}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        time[0] = 0;
        ways[0] = 1;

        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] token = pq.poll();
            int nd = (int)token[0];
            long timeTaken = token[1];

            if (timeTaken > time[nd]) continue;

            for (int[] edge: adj.get(nd)) {
                int nbr = edge[0];
                int tm = edge[1];

                long newTime = tm + timeTaken;

                if (newTime < time[nbr]) {
                    time[nbr] = newTime;
                    ways[nbr] = ways[nd] % MOD;
                    pq.offer(new long[]{nbr, time[nbr]});
                } else if (newTime == time[nbr]) {
                    ways[nbr] = (ways[nbr] + ways[nd]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}