class Solution {
    public boolean isPossibleDivide(int[] hand, int k) {
        if (hand.length % k != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());

        while(!pq.isEmpty()) {
            int val = pq.peek();

            for (int i = val; i < val + k; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0) {
                    if (i != pq.peek()) {
                        return false;
                    }
                    pq.poll();
                }
            }
        }

        return true;
    }
}