class DisjointSet {

    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    int component;

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
        component = n;
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            component--;
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            component--;
        }
    }
}
class Solution {
    public int minCost(int n, int[][] edges, int k) {
        int lo = 0;
        int hi = (int)1e6;

        int result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(edges, k, n, mid)) {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return result;
    }

    public boolean check(int[][] edges, int k, int n, int val) {
        int cnt = 0;
        DisjointSet ds = new DisjointSet(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (w > val) continue;
            ds.unionBySize(u, v);
        }

        return ds.component <= k;
    }
}

