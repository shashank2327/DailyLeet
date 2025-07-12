class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        boolean[] vis = new boolean[26];

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            while (!st.isEmpty() && !vis[ch - 'a'] && st.peek() > ch) {
                if (freq[st.peek() - 'a'] > 1) {
                    freq[st.peek() - 'a']--;
                    vis[st.peek() - 'a'] = false;
                    st.pop();
                } else {
                    break;
                }
            }
            if (vis[ch - 'a']) {
                freq[ch - 'a']--;
                continue;
            }
            st.push(ch);
            vis[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}