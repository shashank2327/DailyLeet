class Solution {
    public int maximumDetonation(int[][] bombs) {
        int numberOfBombs = bombs.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numberOfBombs; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < numberOfBombs; i++) {
            for (int j = 0; j < numberOfBombs; j++) {
                if (i == j) continue;
                if (inRange(bombs, i, j)) {
                    adjList.get(i).add(j);
                }
            }
        }

        boolean[] vis = new boolean[numberOfBombs];
        int maxDetonation = 0;
        for (int i = 0; i < numberOfBombs; i++) {
            vis = new boolean[numberOfBombs];
            if (!vis[i]) {
                int detonations = bfs(adjList, i, vis);
                maxDetonation = Math.max(maxDetonation, detonations);
            }
        }

        return maxDetonation;
    }

    private int bfs(List<List<Integer>> adjList, int node, boolean[] vis) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        vis[node] = true;
        queue.offer(node);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int nde = queue.poll();
                for (int adjNode : adjList.get(nde)) {
                    if (!vis[adjNode]) {
                        count++;
                        queue.offer(adjNode);
                        vis[adjNode] = true;
                    }
                }
            }
        }
        return count;
    }


    private boolean inRange(int[][] bombs, int i, int j) {
        int x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2]; // info of bomb1;
        int x2 = bombs[j][0], y2 = bombs[j][1], r2 = bombs[j][2]; // info of bomb2;

        long maxRadiusSquare = (long)Math.pow(r1, 2);
        long xAbs = (long)Math.abs(x1 - x2);
        long yAbs = (long)Math.abs(y1 - y2);
        long distanceSquare = (xAbs * xAbs) + (yAbs * yAbs);

        if (maxRadiusSquare >= distanceSquare) {
            return true;
        }
        return false;
    }
}
// when can we say one bomb comes in another bomb range;
// when the distance between two bombs is <= Math.max(r1, r2);