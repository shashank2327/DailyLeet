class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] relation: relations) {
            adj.get(relation[0] - 1).add(relation[1] - 1);
            indegree[relation[1] - 1]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int level = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int nd = q.poll();
                for (int nbr: adj.get(nd)) {
                    indegree[nbr]--;
                    if (indegree[nbr] == 0) {
                        q.offer(nbr);
                    }
                }
            }
            level++;
        }

        for (int num: indegree) {
            if (num != 0) return -1;
        }

        return level;
    }
}