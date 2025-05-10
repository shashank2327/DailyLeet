import java.util.*;

class Pair {
    int node, weight;
    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int maxWeight(int n, int[][] edges, int k, int t) {
        // Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        return maximumPathSum(n, adj, k, t);
    }

    public int maximumPathSum(int n, List<List<Pair>> adj, int k, int t) {
        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (Pair p : adj.get(u)) {
                indegree[p.node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo.add(u);
            for (Pair p : adj.get(u)) {
                if (--indegree[p.node] == 0) {
                    queue.add(p.node);
                }
            }
        }

        List<Set<Integer>[]> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // @SuppressWarnings("unchecked")
            Set<Integer>[] temp = new HashSet[k + 1];
            for (int j = 0; j <= k; j++) {
                temp[j] = new HashSet<>();
            }
            dp.add(temp);
        }

        for (int u = 0; u < n; u++) {
            dp.get(u)[0].add(0);
        }

        for (int u : topo) {
            for (int e = 0; e < k; e++) {
                for (int sum : dp.get(u)[e]) {
                    for (Pair p : adj.get(u)) {
                        int newSum = sum + p.weight;
                        if (newSum < t) {
                            dp.get(p.node)[e + 1].add(newSum);
                        }
                    }
                }
            }
        }

        int maxSum = -1;
        for (int u = 0; u < n; u++) {
            for (int sum : dp.get(u)[k]) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
