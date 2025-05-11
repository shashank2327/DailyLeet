class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = richer.length;
        int[] indegree = new int[n];
        for (int i = 0; i < m; i++) {
            adj.get(richer[i][0]).add(richer[i][1]);
            indegree[richer[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, (int) 1e9);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (ans[node] == (int) 1e9) {
                ans[node] = node;
            } else{
                if (quiet[node] < quiet[ans[node]]) {
                    ans[node] = node;
                }
            }
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
                if (ans[it] == (int) 1e9) {
                    ans[it] = ans[node];
                } else if (quiet[ans[node]] < quiet[ans[it]]) {
                    ans[it] = ans[node];
                }
            }
        }

        return ans;
    }
}