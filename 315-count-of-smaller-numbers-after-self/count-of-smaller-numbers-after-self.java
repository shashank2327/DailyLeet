class FenwickTree {
    int n;
    int[] bit;

    FenwickTree(int n) {
        this.n = n;
        bit = new int[n + 1];
    }

    void update(int i, int delta) {
        while (i <= n) {
            bit[i] += delta;
            i += i & -i;
        }
    }

    int query(int i) {
        int sum = 0;

        while (i > 0) {
            sum += bit[i];
            i -= i & -i;
        }

        return sum;
    }
}


class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Ranking and Cordinate Compression;
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (m == 0 || sorted[i] != sorted[m - 1]) {
                sorted[m] = sorted[i];
                m++;
            }
        }

        FenwickTree tree = new FenwickTree(m);

        List<Integer> ans = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            int val = nums[i];
            int rank = binarySearch(sorted, m, val) + 1;

            ans.add(tree.query(rank - 1)); // strictly smaller elements;

            tree.update(rank, 1);
        }

        Collections.reverse(ans);

        return ans;
    }


    private int binarySearch(int[] a, int n, int val) {
        int lo = 0;
        int hi = n - 1;

        int res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] >= val) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }
}