class Solution {
    public String longestPrefix(String s) {
        int[] lps = computeLPS(s);
        int len = lps[lps.length - 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public int[] computeLPS(String s) {
        int n = s.length();

        int[] lps = new int[n];
        int len = 0;
        lps[0] = 0;

        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    i++;
                }
            }
        }

        return lps;
    }
}