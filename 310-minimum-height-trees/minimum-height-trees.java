class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = edges.length;
        int[] indegree = new int[n];
        for (int i = 0; i < m; i++) {
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }

        while (n > 2) {
            int size = q.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int node = q.remove();
                for (int adjNode : adj.get(node)) {
                    indegree[adjNode]--;
                    if (indegree[adjNode] == 1) {
                        q.offer(adjNode);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            res.add(q.remove());
        }
        return res;
    }
}