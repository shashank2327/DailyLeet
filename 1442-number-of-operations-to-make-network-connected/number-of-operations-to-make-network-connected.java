class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    public int findUPar(int n) {
        if (parent.get(n) == n) {
            return n;
        }

        int ulp = findUPar(parent.get(n));
        parent.set(n, ulp);
        return ulp;
    }

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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);

        int extra = 0;
        for (int[] connection: connections) {
            int u = connection[0];
            int v = connection[1];

            if (ds.findUPar(u) != ds.findUPar(v)) {
                ds.unionBySize(u, v);
            } else {
                extra++;
            }
        }

        int disconnectComponent = 0;

        for (int i = 0; i < n; i++) {
            if (ds.findUPar(i) == i) disconnectComponent++;
        }

        int req = disconnectComponent - 1;

        if (extra >= req) {
            return req;
        } else {
            return -1;
        }
    }
}