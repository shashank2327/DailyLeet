class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        String res = "";
        int resLen = 0;

        for (int i = 0; i < n; i++) {
            //oddLength;
            int l = i;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (resLen < r - l + 1) {
                    resLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                r++;
                l--;
            }

            // evenLength;
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (resLen < r - l + 1) {
                    resLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                r++;
                l--;
            }
        }

        return res;
    }
}