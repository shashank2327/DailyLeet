class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int prevEnd = 0;
        for (int i = 0; i < n; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            if (prevEnd >= end) continue;
            if (start > prevEnd) {
                ans += start - prevEnd - 1;
            }

            prevEnd = end;
        }
        ans += days - prevEnd;
        return ans;
    }

    //  1, 3
    //  5, 7
    //  9, 10
}