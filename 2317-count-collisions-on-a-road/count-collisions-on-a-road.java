class Solution {
    public int countCollisions(String directions) {
        Stack<Character> st = new Stack<>();

        int count = 0;
        
        for (char ch : directions.toCharArray()) {
            if (ch == 'L') {
                if (!st.isEmpty() && st.peek() == 'R') {
                    st.pop();
                    count += 2;
                    ch = 'S';

                    while (!st.isEmpty() && st.peek() == 'R') {
                        st.pop();
                        count += 1;
                    }
                } else if (!st.isEmpty() && st.peek() == 'S') {
                    count += 1;
                    ch = 'S';
                } else {
                    continue;
                }
            } else if (ch == 'S') {
                while (!st.isEmpty() && st.peek() == 'R') {
                    st.pop();
                    count += 1;
                }
            }

            if (ch == 'R' || ch == 'S') {
                st.push(ch);
            }
        }


        return count;
    }
}