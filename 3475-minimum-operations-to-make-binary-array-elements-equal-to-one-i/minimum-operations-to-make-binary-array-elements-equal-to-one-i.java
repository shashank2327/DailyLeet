class Solution {
    public int minOperations(int[] a) {
        int n = a.length;
        int i = 0;
        int cnt = 0;
        while (i < n - 2) {
            if (a[i] == 0) {
                a[i] = 1;
                a[i + 1] = a[i + 1] ^ 1;
                a[i + 2] = a[i + 2] ^ 1;
                cnt++;
            }
            i++;
        }

        if (a[n - 1] == 0 || a[n - 2] == 0) return -1;

        return cnt;
    }
}