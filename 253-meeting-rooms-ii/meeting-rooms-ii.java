class Solution {
    public int minMeetingRooms(int[][] intervals) {

        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int cnt = 1;
        pq.add(intervals[0][1]);

        for (int i = 1; i < n; i++) {
            int start_time = intervals[i][0];
            if (pq.peek() > start_time) {
                cnt++;
            } else {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }

        return cnt;
    }
}