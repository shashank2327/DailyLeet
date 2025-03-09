class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int cnt = 0;

        int alterlen = 1;
        int last = colors[0];
        for (int i = 1; i < n + k - 1; i++) {
            int ind = i % n;

            if (colors[ind] == last) {
                alterlen = 1;
                last = colors[ind];
                continue;
            }

            alterlen++;

            if (alterlen >= k) {
                cnt++;
            }

            last = colors[ind];
        }


        return cnt;
    }
}
