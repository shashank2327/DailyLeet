class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> paren = new Stack<>();
        Stack<Integer> star = new Stack<>();

        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (arr[i] == '(') {
                paren.push(i);
            }
            if (arr[i] == '*') {
                star.push(i);
            }
            if (arr[i] == ')') {
                if (!paren.isEmpty()) {
                    paren.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while (!paren.isEmpty() && !star.isEmpty()) {

            if (paren.pop() > star.pop()) return false;
        }

        return paren.isEmpty();
    }
}