import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Arrays.sort(reservedSeats, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int prevRow = 0;

        int[] a = new int[11];

        for (int i = 0; i < reservedSeats.length; i++) {

            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];

            // Rows before the first reserved row
            if (i == 0) {
                count += 2 * (row - 1);
            }

            // We have moved to a new row
            if (i != 0 && row != prevRow) {

                // Completely empty rows between prevRow and row
                count += 2 * (row - prevRow - 1);

                // Prefix sum
                for (int j = 1; j <= 10; j++) {
                    a[j] += a[j - 1];
                }

                // Process previous row
                count += countGroups(a);

                Arrays.fill(a, 0);
            }

            prevRow = row;
            a[seat]++;
        }

        // Process the last reserved row
        for (int j = 1; j <= 10; j++) {
            a[j] += a[j - 1];
        }

        count += countGroups(a);

        // Completely empty rows after the last reserved row
        count += 2 * (n - prevRow);

        return count;
    }

    private int countGroups(int[] prefix) {

        // Seats 2,3,4,5
        boolean left = (prefix[5] - prefix[1] == 0);

        // Seats 4,5,6,7
        boolean middle = (prefix[7] - prefix[3] == 0);

        // Seats 6,7,8,9
        boolean right = (prefix[9] - prefix[5] == 0);

        // Left and right don't overlap
        if (left && right) {
            return 2;
        }

        if (left || middle || right) {
            return 1;
        }

        return 0;
    }
}