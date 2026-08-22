class Solution {
    public String shortestPalindrome(String s) {

        int n = s.length();

        String str = s + "#" + reverseString(s);

        int[] lps = computeLPS(str);
        int len = lps[lps.length - 1];

        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= len; i--) {
            sb.append(s.charAt(i));
        }

        sb.append(s);

        return sb.toString();
    }

    private int[] computeLPS(String s) {
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
                if (len == 0) {
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }

        return lps;
    }

    private String reverseString(String s) {
        StringBuilder sb = new StringBuilder();

        sb.append(s);

        return sb.reverse().toString();
    }
}