class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            graph.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] topo = new int[numCourses];
        int i = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            topo[i++] = node;
            for (int it : graph.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.offer(it);
            }
        }

        return i == numCourses ? topo : new int[0];
    }
}