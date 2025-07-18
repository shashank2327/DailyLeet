class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            long val = spells[i];
            long required = (success + val - 1) / val;

            int idx = binarySearch(potions, required);
            if (idx == -1) {
                result[i] = 0;
            } else {
                result[i] = m - idx;
            }
        }

        return result;
    }

    public int binarySearch(int[] a, long val) {
        int lo = 0;
        int hi = a.length - 1;
        int idx = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] >= val) {
                idx = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return idx;
    }
}