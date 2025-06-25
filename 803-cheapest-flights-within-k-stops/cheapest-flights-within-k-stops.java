class Pair {
    int node;
    int cost;

    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] route : flights) {
            int u = route[0];
            int v = route[1];
            int cst = route[2];
            graph.get(u).add(new int[]{v, cst});
        }

        int[] minCost = new int[n];
        Arrays.fill(minCost, (int)1e9);

        Queue<Pair> q = new LinkedList<>();
        minCost[src] = 0;
        q.offer(new Pair(src, 0));
        int level = 0;
        while (!q.isEmpty()) {
            if (level > k) break;
            int sz = q.size();
            while(sz-- > 0) {
                Pair it = q.poll();
                int node = it.node;
                int cost = it.cost;

                for (int[] child : graph.get(node)) {
                    int childNode = child[0];
                    int costReq = child[1];

                    if (costReq + cost < minCost[childNode]) {
                        minCost[childNode] = costReq + cost;
                        q.offer(new Pair(childNode, costReq + cost));
                    }
                }
            }
            level++;
        }

        return minCost[dst] == (int)1e9 ? -1 : minCost[dst];
    }
}
