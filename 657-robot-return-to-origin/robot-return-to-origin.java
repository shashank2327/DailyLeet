class Solution {
    public boolean judgeCircle(String s) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                sum1--;
            } else if (s.charAt(i) == 'R') {
                sum1++;
            } else if (s.charAt(i) == 'D') {
                sum2--;
            } else {
                sum2++;
            }
        }

        if (sum1 == 0 && sum2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}