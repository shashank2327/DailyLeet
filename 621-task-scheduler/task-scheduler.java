class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for(char task: tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num: freq) {
            if (num > 0) {
                pq.offer(num);
            }
        }

        // keep track of cooldown tasks;
        Queue<int[]> q = new LinkedList<>(); // (cnt, time when task can be readded)

        int time = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int curr = pq.poll() - 1;
                if (curr > 0) {
                    q.offer(new int[]{curr, time + n});
                }
            }

            if (!q.isEmpty()) {
                if (q.peek()[1] == time) {
                    pq.offer(q.poll()[0]);
                }
            }
        }

        return time;
    }
}