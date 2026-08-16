class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Pair> q = new LinkedList<>();
        int[] vis = new int[n];

        q.add(new Pair(0, -1));
        vis[0] = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Pair it = q.poll();
                int nd = it.first;
                int par = it.second;

                for (int nbr: adj.get(nd)) {
                    if (vis[nbr] == 1 && nbr != par) {
                        return false;
                    }
                    if (vis[nbr] == 0) {
                        vis[nbr] = 1;
                        q.add(new Pair(nbr, nd));
                    }
                }
            }
        }

        for (int num : vis) {
            if (num == 0) return false;
        }

        return true;
    }
}