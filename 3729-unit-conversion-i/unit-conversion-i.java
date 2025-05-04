class Pair {
    int node;
    int factor;

    public Pair (int node, int factor) {
        this.node = node;
        this.factor = factor;
    }
}

class Solution {
    public static final int MOD = (int) (1e9 + 7);
    public int[] baseUnitConversions(int[][] conversions) {
        int len = conversions.length + 1;
        int[] a = new int[len];
        a[0] = 1;

        // go to every node from 0 keeping track of previous factor;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < len - 1; i++) {
            int node1 = conversions[i][0];
            int node2 = conversions[i][1];
            int fac = conversions[i][2];

            adj.get(node1).add(new Pair(node2, fac));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 1));

        while (!q.isEmpty()) {
            int n = q.peek().node;
            int f = q.peek().factor;
            q.remove();

            for (Pair p : adj.get(n)) {
                int n1 = p.node;
                long fac = p.factor;
                if (a[n1] == 0) {
                    long val = f * fac;
                    int actual = (int) (val % MOD);
                    a[n1] = actual;
                    q.add(new Pair(n1, a[n1]));
                }
            }
        }

        return a;
    }
}