class Solution {
    public boolean isNStraightHand(int[] hand, int k) {
        int n = hand.length;
        if (n % k != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());

        while (!pq.isEmpty()) {
            int val = pq.peek();

            for (int i = val; i < val + k; i++) {
                if (!map.containsKey(i)) return false;

                map.put(i, map.get(i) - 1);

                if (map.get(i) == 0) {
                    // if (i != pq.peek()) {
                    //     return false;
                    // }
                    pq.poll();
                }
            }
        }

        return true;
    }
}

/*
    1 2 2 3 3 4 6 7 8

    1 - 1
    2 - 2
    3 - 2
    4 - 1
    6 - 1
    7 - 1
    8 - 1

*/