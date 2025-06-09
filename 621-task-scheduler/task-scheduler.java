class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : freq.values()) {
            maxHeap.add(cnt);
        }

        // keep track of cooldown tasks;
        Queue<int[]> q = new LinkedList<>(); // (cnt, time when task can be re-added);

        int time = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int curr = maxHeap.poll() - 1;
                if (curr > 0) {
                    q.offer(new int[]{curr, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}