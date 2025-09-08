class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            boolean check1 = check(i);
            boolean check2 = check(n - i);
            if (check1 && check2) {
                return new int[]{i, n - i};
            }
        }

        return new int[]{-1};
    }

    public boolean check(int n) {
        String s = String.valueOf(n);

        for (char ch : s.toCharArray()) {
            if (ch == '0') return false;
        }

        return true;
    }
}