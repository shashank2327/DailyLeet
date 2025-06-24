class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();

        int number = 0;
        int result = 0;
        int sign = 1;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0'); // make the number
            } else if (ch == '+') {
                result += (number * sign);
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += (number * sign);
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                st.push(result);
                st.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            } else if (ch == ')') {
                result += (number * sign);
                number = 0;

                int stackSign = st.pop();
                int lastResult = st.pop();

                result  = result * stackSign;

                result += lastResult;
            }
        }

        result += number*sign;
        return result;
    }
}