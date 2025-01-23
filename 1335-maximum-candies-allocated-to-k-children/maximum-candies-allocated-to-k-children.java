class Solution {
    public int maximumCandies(int[] A, long k) {
        int left = 0;
        int right = 10_000_000;
        while (left < right) {
            long sum = 0;
            int mid = (left + right + 1) / 2;
            for (int a : A) {
                sum += a/mid;
            }

            if (sum < k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
    // 5 + 8 + 6 = 19
    // 19 / 3 = 6
    // 5/ 6 + 8/ 6 + 6/ 6 = 2; Not Possible.



    // minimum chocolate to each student will be 1;
    // maximum chocolate to each student Max candies.
}