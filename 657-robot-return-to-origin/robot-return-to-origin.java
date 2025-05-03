class Solution {
    public boolean judgeCircle(String s) {
        int sum1 = 0;
        int sum2 = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') {
                sum1--;
            } else if (c == 'R') {
                sum1++;
            } else if (c == 'D') {
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