class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        generate(2 * n, ls, "");
        return ls;
    }
    public void generate(int n, List<String> result, String s) {
        if (n == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }

        generate(n - 1, result, s + '(');
        generate(n - 1, result, s + ')');
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push('(');
            } else {
                if (st.isEmpty() || st.peek() != '(') {
                    return false;
                } else {
                    st.pop();
                }
            }
        }

        return st.isEmpty();
    }
}