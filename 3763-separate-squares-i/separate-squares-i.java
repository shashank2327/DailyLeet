class Solution {

    boolean isPossible(int[][] pq, double mid) {
        double area1 = 0.0, area2 = 0.0;

        for (int i = 0; i < pq.length; i++) {
            int y = pq[i][1];
            int side = pq[i][2];

            if (y + side <= mid) {
                area1 += Math.pow(side, 2);
            } else if (y >= mid) {
                area2 += Math.pow(side, 2);
            } else {
                area1 += side * (mid - y);
                area2 += side * (y + side - mid);
            }
        }
        return area1 < area2;
    }

    public double separateSquares(int[][] squares) {

        double l = 0.0;
        double r = 2 * 1e9;
        double epsilon = 0.00001;

        while (Math.abs(l - r) >= epsilon) {
            double mid = (l + r) / 2.0;
            
            if (isPossible(squares, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return r;
    }
}