class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int m = adjacentPairs.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = adjacentPairs[i][0];
            int v = adjacentPairs[i][1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
            outdegree.put(v, outdegree.getOrDefault(v, 0) + 1);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int key : outdegree.keySet()) {
            if (outdegree.get(key) == 1) {
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