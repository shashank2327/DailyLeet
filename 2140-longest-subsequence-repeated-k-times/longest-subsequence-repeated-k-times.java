class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // BFS
        String curr = "";
        Queue<String> q = new LinkedList<>();
        q.offer(curr);
        String res = "";

        while (!q.isEmpty()) {
            curr = q.poll();

            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (freq[ch - 'a'] < k) {
                    continue;
                }
                String next = curr + ch;
                if (countSubseq(s, next) >= k) {
                    res = next;
                    q.offer(next);
                }
            }
        }

        return res;
    }

    private int countSubseq(String s, String next) {
        int i = 0;
        int j = 0;
        int m = next.length();
        int cnt = 0;

        while (i < s.length()) {
            if (s.charAt(i) == next.charAt(j)) {
                j++;
                if (j == m) {
                    j = 0;
                    cnt++;
                }
            }
            i++;
        }


        return cnt;
    }
}