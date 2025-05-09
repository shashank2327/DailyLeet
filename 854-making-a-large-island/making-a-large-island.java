class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n - 1);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;
                int[] dx = {1, -1, 0, 0};
                int[] dy = {0, 0, 1, -1};
                for (int i = 0; i < 4; i++) {
                    int nr = row + dx[i];
                    int nc = col + dy[i];
                    if (nr < n && nc < n && nr >= 0 && nc >= 0 && grid[nr][nc] == 1) {
                        int currNode = row * n + col;
                        int adjNode = nr * n + nc;
                        ds.unionBySize(currNode, adjNode);
                    }
                }
            }
        }

        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;
                int[] dx = {1, -1, 0, 0};
                int[] dy = {0, 0, 1, -1};
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < 4; i++) {
                    int nr = row + dx[i];
                    int nc = col + dy[i];
                    if (nr < n && nc < n && nr >= 0 && nc >= 0 && grid[nr][nc] == 1) {
                        int node = nr * n + nc;
                        set.add(ds.findUPar(node)); 
                    }
                }

                int currSize = 0;
                for (int ultParent : set) {
                    currSize += ds.size.get(ultParent);  // getting size of ultimate parent
                }

                max = Math.max(max, currSize + 1);
            }
        }

        for (int i = 0; i < n * n; i++) {
            max = Math.max(max, ds.size.get(ds.findUPar(i)));
        }

        return max;
    }
}