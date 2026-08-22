class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        int[] lps = computeLPS(needle);

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        if (j != m) {
            return -1;
        } else {
            return i - j;
        }
    }

    private int[] computeLPS(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M];

        int len = 0;
        lps[0] = 0;

        int i = 1;
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;

    }
}