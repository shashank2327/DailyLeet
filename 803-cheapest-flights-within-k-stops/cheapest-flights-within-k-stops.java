class Pair {
    int cost;
    int node;

    Pair (int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Tuple {
    int first;
    int second;
    int third;

    Tuple (int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        int[] cst = new int[n];
        Arrays.fill(cst, (int)1e9);
        cst[src] = 0;

        while (!q.isEmpty()) {
            Tuple it = q.peek();
            q.remove();
            int stp = it.first;
            int nd = it.second;
            int c = it.third;

            // if (stp > k) {
            //     continue;
            // }

            for (int i = 0; i < adj.get(nd).size(); i++) {
                int adjNode = adj.get(nd).get(i).node;
                int eW = adj.get(nd).get(i).cost;

                if (eW + c < cst[adjNode] && stp <= k) {
                    cst[adjNode] = eW + c;
                    q.add(new Tuple(stp + 1, adjNode, c + eW));
                }
            }
        }

        return cst[dst] == (int)1e9 ? -1 : cst[dst];
    }
}