class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int window = n - k;

        int total = 0;
        for (int point : cardPoints) {
            total += point;
        }

        int max = 0;
        int left = 0;
        int right = 0;
        int curr = 0;
        for (int i = 0; i < window; i++) {
            curr += cardPoints[i];
        }

        max = total - curr;

        for (int i = window; i < n; i++) {
            curr += (cardPoints[i] - cardPoints[left]);
            max = Math.max(max, total - curr);
            left++;
        }

        return max;
    }
}