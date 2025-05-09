class Pair {
    int first;
    int second;

    public Pair (int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < redEdges.length; i++) {
            int u = redEdges[i][0];
            int v = redEdges[i][1];
            adj.get(u).add(new Pair(v, 0));
        }

        for (int i = 0; i < blueEdges.length; i++) {
            int u = blueEdges[i][0];
            int v = blueEdges[i][1];
            adj.get(u).add(new Pair(v, 1));
        }

        // boolean[][][] vis = new boolean[n][n][2];  // u, v, color
        int[][] dis = new int[n][2];
        for (int[] x : dis) {
            Arrays.fill (x, (int) 1e9);
        }
        dis[0][0] = 0;
        dis[0][1] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        q.add(new Pair(0, 1));

        while (!q.isEmpty()) {
            Pair it = q.poll();
            int node = it.first;
            int color = it.second;

            for (Pair token : adj.get(node)) {
                int adjNode = token.first;
                int col = token.second;

                if (col != color && dis[node][color] + 1 < dis[adjNode][col] ) {
                    
                    dis[adjNode][col] = dis[node][color] + 1;
                    q.add(new Pair(adjNode, col));
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (dis[i][0] == (int) 1e9 && dis[i][1] == (int) 1e9) {
                ans[i] = -1;
            } else {
                ans[i] = Math.min(dis[i][0], dis[i][1]);
            }
        }
        return ans;
    }
}