class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int[] outdegree = new int[n];
        for (int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(graph[i][j]).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int it : adj.get(node)) {
                outdegree[it]--;
                if (outdegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        res.sort(null);
        return res;
    }
}