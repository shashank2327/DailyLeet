class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] x : roads) {
            adj.get(x[0]).add(new int[]{x[2], x[1]});
            adj.get(x[1]).add(new int[]{x[2], x[0]});
        }

        int mod = 1_000_000_007;
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        q.add(new long[]{0, 0});
        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        int[] count = new int[n];

        time[0] = 0;
        count[0] = 1;

        while (!q.isEmpty()) {
            long[] curr = q.poll();

            int node = (int) curr[1];
            long currTime = curr[0];

            if (time[node] < currTime) continue;

            for (int[] x : adj.get(node)) {
                long nextTime = (currTime + x[0]);

                if (nextTime < time[x[1]]) {
                    time[x[1]] = nextTime;
                    count[x[1]] = count[node];
                    q.offer(new long[]{time[x[1]], x[1]});
                } else if (nextTime == time[x[1]]) {
                    count[x[1]] = (count[x[1]] + count[node]) % mod;
                }
            }
        }

        return count[n - 1];
    }
}