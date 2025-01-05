class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] pSum = new int[n + 1];
        for (int i = 0; i < shifts.length; i++) {
                if (shifts[i][2] == 0) {
                    pSum[shifts[i][0]] += -1;
                    pSum[shifts[i][1] + 1] += 1;
                } else {
                    pSum[shifts[i][0]] += 1;
                    pSum[shifts[i][1] + 1] += -1;
                }
        }

        for (int i = 1; i < n; i++) {
            pSum[i] += pSum[i - 1];
        }
        // (char) (((ch - 'a' + x) % 26 + 26) % 26 + 'a');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int x = pSum[i];
            char actual = (char) (((ch - 'a' + x) % 26 + 26) % 26 + 'a');
            sb.append(actual);
        }

        return sb.toString();
    }
}