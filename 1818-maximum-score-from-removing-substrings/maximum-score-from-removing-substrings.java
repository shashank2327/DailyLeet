class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return gain(s, "ab", x, y);
        } else {
            return gain(s, "ba", y, x);
        }
    }
    private int gain(String s, String target, int x, int y) {
        int totalPoints = 0;
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (!st.isEmpty() && st.peek() == target.charAt(0) && s.charAt(i) == target.charAt(1)) {
                totalPoints += x;
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }   
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        s = sb.reverse().toString();
        n = s.length();
        System.out.println(s);
        for (int i = 0; i < n; i++) {
            if (!st.isEmpty() && st.peek() == target.charAt(1) && s.charAt(i) == target.charAt(0)) {
                totalPoints += y;
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }  

        return totalPoints;
    }
}

/*
if x > y -> try to remove all the occurence of ab first
if y > x -> try to remove all the occurence of ba first;

cdbcbbaaabab
cd      a  b 
*/