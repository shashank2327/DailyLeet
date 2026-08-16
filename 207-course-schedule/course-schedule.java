class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        } 

        int[] indeg = new int[numCourses];

        for (int[] edge: prerequisites) {
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
            indeg[u]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) q.add(i);
        }


        while (!q.isEmpty()) {
            int nd = q.poll();
            for (int nbr: adj.get(nd)) {
                indeg[nbr]--;
                if (indeg[nbr] == 0) q.add(nbr);
            }
        }

        for (int deg: indeg) {
            if (deg > 0) return false;
        }

        return true;
    }
}