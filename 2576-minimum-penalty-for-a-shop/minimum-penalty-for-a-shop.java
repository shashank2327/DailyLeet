class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int yesCnt = 0;
        int noCnt = 0;

        for (char ch : customers.toCharArray()) {
            if (ch == 'Y') yesCnt++;
        }

        int min = Integer.MAX_VALUE;
        int idx = -1;

        for (int i = 0; i < n; i++) {
            char token = customers.charAt(i);
            int penalty = 0;

            if (token == 'Y') {
                penalty += yesCnt + noCnt;
                yesCnt--;
            } else {
                penalty += yesCnt + noCnt;
                noCnt++;
            }

            if (penalty < min) {
                min = penalty;
                idx = i;
            }
        }

        if (noCnt < min) idx = n;

        return idx;

    }
}