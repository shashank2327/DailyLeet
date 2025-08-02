class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int m = Integer.MAX_VALUE;
        for (int b1 : basket1) {
            freq.put(b1, freq.getOrDefault(b1, 0) + 1);
            m = Math.min(m, b1);
        }

        for (int b2 : basket2) {
            freq.put(b2, freq.getOrDefault(b2, 0) - 1);
            m = Math.min(m, b2);
        }

        List<Integer> merged = new ArrayList<>();

        for (var entry : freq.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                merged.add(entry.getKey());
            }
        }

        Collections.sort(merged);
        long res = 0;
        for (int i = 0; i < merged.size() / 2; i++) {
            res += Math.min(2 * m, merged.get(i));
        }

        return res;
    }
}

/*
    2 2 2 4
    1 1 2 4


    1 -> 2
    2 -> 2

*/