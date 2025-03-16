class Solution {
    public long repairCars(int[] ranks, int cars) {
        int min = ranks[0];
        int max = ranks[0];
        for (int rank : ranks) {
            min = Math.min(min, rank);
            max = Math.max(max, rank);
        }
        int[] freq = new int[max + 1];
        for (int rank : ranks) {
            freq[rank]++;
        }

        long l = 1;
        long h = 1L * min * cars * cars;

        while (l < h) {
            long m = l + (h - l) / 2;
            long cnt = 0;
            for (int i = 1; i <= max; i++) {
                cnt += freq[i] * (long) Math.sqrt(m / (long) i);
            }

            if (cnt >= cars) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}