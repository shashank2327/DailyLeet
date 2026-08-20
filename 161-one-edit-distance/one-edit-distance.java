class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (Math.abs(n - m) > 1) return false;

        if (n == m) {
            return checkForEqualLength(s, t);
        } else if (n < m) {
            return checkForUnequalLength(t, s);
        } else {
            return checkForUnequalLength(s, t);
        }

    }

    private boolean checkForEqualLength(String s, String t) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                cnt++;
            }
        }

        return cnt == 1;
    }

    private boolean checkForUnequalLength(String s, String t) {
        // considering s.length() > t.length();

        int i = 0;
        int j = 0;

        int cnt = 0;

        while (i < s.length()) {
            if (j == t.length()) break;

            if (s.charAt(i) != t.charAt(j)) {
                cnt++;
                i++;
            } else {
                i++;
                j++;
            }
        }

        cnt += s.length() - i;

        return cnt == 1;
    }
}

/*
    if s.length() < t.length() -> we have to insert the character;
    if.slength() == t.lenght() -> we have to replace the character;
    if s.length() > t.lenght() -> we have to delete the character;


    but in all of the three cases one thing that remain same is ordering of the character;

    s.length() < t.length() is same is s.length() > t.length();
    we have to just exchange the s and t;
*/