class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            if (!stack.isEmpty() && Character.isDigit(a[i]) && !Character.isDigit(stack.peek())) {
                stack.pop();
                i++;
            } else {
                stack.push(a[i]);
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}