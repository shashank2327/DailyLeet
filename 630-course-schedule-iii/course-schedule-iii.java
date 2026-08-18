class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course: courses) {
            int dur = course[0];
            int end = course[1];
            if (time + dur <= end) {
                time += dur;
                pq.offer(dur);
            } else {
                if (!pq.isEmpty() && pq.peek() > dur) {
                    time += dur - pq.poll();
                    pq.offer(dur);
                }
            }
        }

        return pq.size();
    }
}

/*
100   200
1000 1250
200  1300
2000 3200
*/