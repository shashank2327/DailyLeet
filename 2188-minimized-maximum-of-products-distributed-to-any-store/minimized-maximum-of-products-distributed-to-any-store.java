class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 0;
        int high = Arrays.stream(quantities).max().getAsInt();
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (solve(n, quantities, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }


    private boolean solve(int n, int[] quantities, int item) {
        if (item == 0) return false;
        int store = 0;
        for (int i = 0; i < quantities.length; i++) {
            int quotient = quantities[i] / item;
            int remainder = quantities[i] % item == 0 ? 0 : 1;
            store += quotient + remainder;
            if (store > n) return false;
        }
        return true;
    }
}