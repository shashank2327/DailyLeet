class Pair {
    int node; // node i am directed to;
    int factor; // factor required;

    public Pair(int node, int factor) {
        this.node = node;
        this.factor = factor;
    }
}
class Solution {

    private static final int MOD = (int)1e9 + 7;

    public int[] baseUnitConversions(int[][] conversions) {
        
        int nodes = conversions.length + 1;
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        
        for (int[] conversion : conversions) {
            int source = conversion[0];
            int target = conversion[1];
            int factor = conversion[2];

            graph.get(source).add(new Pair(target, factor));
        }

        int[] baseUnit = new int[nodes];

        Queue<Pair> q = new LinkedList<>();
        baseUnit[0] = 1;
        q.offer(new Pair(0, 1));

        while (!q.isEmpty()) {
            Pair token = q.poll();
            int node = token.node;
            int prevFactor = token.factor;

            for (Pair adj : graph.get(node)) {
                int adjNode = adj.node;
                long currentFactor = adj.factor;
                if (baseUnit[adjNode] == 0) {
                    long baseFactor = (currentFactor * prevFactor) % MOD;
                    baseUnit[adjNode] = (int)baseFactor;
                    q.offer(new Pair(adjNode, (int)baseFactor));
                } 
            }
        }

        return baseUnit;
    }
}