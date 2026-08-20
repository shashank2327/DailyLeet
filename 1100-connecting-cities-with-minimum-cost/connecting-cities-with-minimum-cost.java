class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int minimumCost(int n, int[][] connections) {


        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] connection: connections) {
            int u = connection[0] - 1;
            int v = connection[1] - 1;
            int wt = connection[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.second, b.second));

        int[] vis = new int[n];

        pq.offer(new Pair(0, 0));
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair it = pq.poll();
            int nd = it.first;
            int cst = it.second;

            if (vis[nd] == 1) continue;
            vis[nd] = 1;
            sum += cst;

            for (Pair tok: adj.get(nd)) {
                int nbr = tok.first;
                int wt = tok.second;

                if (vis[nbr] == 0) {
                    pq.offer(new Pair(nbr, wt));
                }
            }
        }

        for (int num: vis) {
            if (num == 0) return -1;
        }

        return sum;
    }
}