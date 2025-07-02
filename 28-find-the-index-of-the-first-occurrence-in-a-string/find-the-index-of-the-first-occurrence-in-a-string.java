class Solution {
    public int strStr(String aStr, String bStr) {
        int[] lps = prefixSuffix(bStr.toCharArray());

        int i = 0;
        int j = 0;
        char[] a = aStr.toCharArray();
        char[] b = bStr.toCharArray();
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j != b.length) return -1;
        return i - j;
    }

    private int[] prefixSuffix(char[] pattern) {
        int[] lps = new int[pattern.length];
        int index = 0;

        for (int i = 1; i < pattern.length;) {
            if (pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}