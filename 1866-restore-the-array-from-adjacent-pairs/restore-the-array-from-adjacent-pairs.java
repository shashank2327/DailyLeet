class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int m = adjacentPairs.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = adjacentPairs[i][0];
            int v = adjacentPairs[i][1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                q.add(key);
                break;
            }
        }
        Set<Integer> seen = new HashSet<>();
        seen.add(q.peek());
        int[] res = new int[m + 1];
        res[0] = q.peek();
        int idx = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : graph.get(node)) {
                if (!seen.contains(child)) {
                    seen.add(child);
                    res[idx++] = child;
                    q.offer(child);
                }
            }
        }

        return res;
    }
}