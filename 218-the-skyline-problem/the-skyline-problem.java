import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;

        int[][] events = new int[2 * n][2];

        int i = 0;

        for (int[] building : buildings) {
            int start = building[0];
            int end = building[1];
            int height = building[2];

            // Starting event
            events[i][0] = start;
            events[i][1] = -height;
            i++;

            // Ending event
            events[i][0] = end;
            events[i][1] = height;
            i++;
        }

        // Sort by x-coordinate, then by height
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Max-heap behavior using reverse order
        // Stores height -> frequency
        TreeMap<Integer, Integer> map =
            new TreeMap<>(Collections.reverseOrder());

        map.put(0, 1);

        int prevHeight = 0;

        List<List<Integer>> res = new ArrayList<>();

        for (int[] event : events) {
            int coordinate = event[0];
            int height = event[1];

            if (height < 0) {
                // Building starts
                int h = -height;
                map.put(h, map.getOrDefault(h, 0) + 1);
            } else {
                // Building ends
                int cnt = map.get(height);

                if (cnt == 1) {
                    map.remove(height);
                } else {
                    map.put(height, cnt - 1);
                }
            }

            // Current maximum height
            int currHeight = map.firstKey();

            // Add a key point only when the skyline changes
            if (prevHeight != currHeight) {
                res.add(Arrays.asList(coordinate, currHeight));
                prevHeight = currHeight;
            }
        }

        return res;
    }
}