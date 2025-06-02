class Pair {
    char bracket;
    int idx;
    public Pair(char bracket, int idx) {
        this.bracket = bracket;
        this.idx = idx;
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n == 0) return 0;
        Stack<Pair> st = new Stack<>();
        int[] binaryArr = new int[n];
        for(int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(new Pair('(', i));
            } else {
                if (!st.isEmpty()) {
                    Pair it = st.pop();
                    binaryArr[it.idx] = 1;
                    binaryArr[i] = 1;
                }
            }
        }
        int max = 0;
        int l = 0;
        int r = 0;
        while (r < n) {
            if (binaryArr[r] == 0) {
                r++;
                l = r;
            } else {
                max = Math.max(max, r - l + 1);
                r++;
            }
        }

        return max;
    }
}