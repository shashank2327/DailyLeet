import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumWidth(int[] planks) {
        int n = planks.length;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Long, Integer> width = new HashMap<>();

        int ans = 0;
        for (int x : planks) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            width.put((long) x, width.getOrDefault((long) x, 0) + 1);

            // 5->2
            ans = Math.max(ans, freq.get(x));
        }

        for (Map.Entry<Integer, Integer> it1 : freq.entrySet()) {
            for (Map.Entry<Integer, Integer> it2 : freq.entrySet()) {
                long sum = 1L * it1.getKey() + it2.getKey();

                if (it1.getKey() < it2.getKey()) {
                    int addedWidth = Math.min(it1.getValue(), it2.getValue());
                    width.put(sum, width.getOrDefault(sum, 0) + addedWidth);
                } else if (it1.getKey().equals(it2.getKey())) {
                    int addedWidth = it1.getValue() / 2;
                    width.put(sum, width.getOrDefault(sum, 0) + addedWidth);
                }
            }
        }

        for (Map.Entry<Long, Integer> it : width.entrySet()) {
            ans = Math.max(ans, it.getValue());
        }

        return ans;
    }
}