class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);
            indegree[nodeA]++;
            indegree[nodeB]++;
        }

        // for breadth first search;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                queue.add(i);
            }
        }

        while (n > 2) {
            int size = queue.size();
            n = n - size;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int adjNode : graph.get(node)) {
                    indegree[adjNode]--;
                    if (indegree[adjNode] == 1) {
                        queue.offer(adjNode);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }


        return result;
    }
}