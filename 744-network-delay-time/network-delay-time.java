class Pair {
    int first;
    int second;

    Pair (int first , int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = times.length;
        for (int i = 0; i < m; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new Pair(v, w));
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, (int)1e9);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

        dis[k] = 0;
        pq.add(new Pair(0, k));

        while (!pq.isEmpty()) {
            int t = pq.peek().first;
            int nde = pq.peek().second;
            pq.remove();

            for (int i = 0; i < adj.get(nde).size(); i++) {
                int nd = adj.get(nde).get(i).first;
                int tm = adj.get(nde).get(i).second;

                if (tm + t < dis[nd]) {
                    dis[nd] = tm + t;
                    pq.add(new Pair(tm + t, nd));
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (dis[i] == (int) 1e9) return -1;
            else max = Math.max(max, dis[i]);
        }


        return max;
    }
}