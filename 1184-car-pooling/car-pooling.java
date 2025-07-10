class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[] points = new int[1001];
        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            points[start] += passengers;
            points[end] -= passengers;
        }

        if (points[0] > capacity) return false;

        for (int i = 1; i <= 1000; i++) {
            points[i] += points[i - 1];
            if (points[i] > capacity) {
                return false;
            }
        }

        return true;
    }
}

/*
    2, 2, 6
    2, 4, 7
    8, 6, 7
*/