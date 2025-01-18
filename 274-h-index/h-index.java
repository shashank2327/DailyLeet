class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int up = upperBound(citations, i);
            int actual = up + 1;
            int numberOfPapers = n - actual;
            if (numberOfPapers >= i) {
                max = i;
            }
        }
        return max;
    }
    private int upperBound(int[] a, int k) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}