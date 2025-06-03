class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        char[] arr = num.toCharArray();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k > 0) {
                if (st.peek() > (arr[i] - '0')) {
                    st.pop();
                    k--;
                } else {
                    break;
                }
            }
            st.push(arr[i] - '0');
        }

        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(sb.reverse());
        int ptr = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                ptr++;
            } else {
                break;
            }
        }
        String ans = sb.substring(ptr, sb.length());
        if (ans.equals("")) {
            return "0";
        } else {
            return ans;
        }
    }
}