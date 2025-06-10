public class DisjointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();


    // Constructor (Taking number of nodes);
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    // Path compression
    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }


    // Finding union using rank;
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }


    // Finding union using size;
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}


class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        int cnt = 0;
        int a = 0;
        int b = 0;
        DisjointSet ds1 = new DisjointSet(n - 1);
        DisjointSet ds2 = new DisjointSet(n - 1);
        for (int[] edge : edges) {
            int u = edge[1] - 1;
            int v = edge[2] - 1;
            if (edge[0] == 3) {
                if (ds1.findUPar(u) != ds1.findUPar(v)) {
                    ds2.unionBySize(u, v);
                    ds1.unionBySize(u, v);
                    a++;
                    b++;
                } else {
                    cnt++;
                }
            } else if (edge[0] == 2) {
                if (ds2.findUPar(u) != ds2.findUPar(v)) {
                    ds2.unionBySize(u, v);
                    b++;
                } else {
                    cnt++;
                }
            } else {
                if (ds1.findUPar(u) != ds1.findUPar(v)) {
                    ds1.unionBySize(u, v);
                    a++;
                } else {
                    cnt++;
                }
            }
        }

        return (b == n - 1 && a == n - 1) ? cnt : -1;
    }
}