class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stk = new Stack<>();
        int n1 = s.length();
        int n2 = part.length();

        for (int i = 0; i < n1; i++) {
            stk.push(s.charAt(i));

            if (stk.size() >= n2 && checkMatch(stk, part, n2)) {
                for (int j = 0; j < n2; j++) {
                    stk.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }

    private boolean checkMatch(Stack<Character> stk, String part, int n2) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stk);
        for (int i = n2 - 1; i >= 0; i--) {
            if (temp.isEmpty() || temp.peek() != part.charAt(i)) {
                return false;
            }
            temp.pop();
        }

        return true;
    }
}