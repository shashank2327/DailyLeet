class Pair {
    int time;
    int node;

    public Pair(int time, int node) {
        this.time = time;
        this.node = node;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : times) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int t = edge[2];
            graph.get(u).add(new int[] {v, t});
        }

        int[] minTime = new int[n]; // minimum time to reach every node;
        Arrays.fill(minTime, (int)1e9);

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.time - p2.time);
        minTime[k - 1] = 0;

        pq.offer(new Pair(0, k - 1));
        while (!pq.isEmpty()) {
            Pair it = pq.poll();
            int time = it.time;
            int node = it.node;

            if (minTime[node] < time) continue;

            for (int[] childs : graph.get(node)) {
                int child = childs[0];
                int edgeWt = childs[1];
                if (edgeWt + time < minTime[child]) {
                    minTime[child] = edgeWt + time;
                    pq.offer(new Pair(minTime[child], child));
                }
            }
        }

        int max = -1;

        for (int num : minTime) {
            max = Math.max(max, num);
        }

        return max == (int)1e9 ? -1 : max;
    }
}