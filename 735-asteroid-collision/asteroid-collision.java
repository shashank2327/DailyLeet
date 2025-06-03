class Solution {
    public int[] asteroidCollision(int[] ast) {
        int n = ast.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (ast[i] > 0 || st.isEmpty()) {
                st.push(ast[i]);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(ast[i])) {
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == Math.abs(ast[i])) {
                    st.pop();
                } else {
                    if (st.isEmpty() || st.peek() < 0) {
                        st.push(ast[i]);
                    }
                }
            }
        }

        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}