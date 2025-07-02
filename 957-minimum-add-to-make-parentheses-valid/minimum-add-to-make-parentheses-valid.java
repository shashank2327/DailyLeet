class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(' ) {
                    st.pop();
                } else {
                    st.push(')');
                }
            } else {
                st.push(ch);
            }
        }

        return st.size();
    }
}