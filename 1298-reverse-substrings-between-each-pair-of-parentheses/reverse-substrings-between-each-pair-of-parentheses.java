class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        Queue<Character> q = new LinkedList<>();

        for (char ch: s.toCharArray()) {
            if (ch == ')') {
                while (!st.isEmpty()) {
                    char it = st.pop();
                    if (it == '(') break;
                    q.add(it);
                }

                while (!q.isEmpty()) {
                    st.push(q.poll());
                }
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}