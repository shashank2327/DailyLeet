class Solution {
    public int minimumRecolors(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = k;
        
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (s.charAt(i) == 'W') cnt++;
        }
        int currCnt = cnt;
        while (r < n) {
            if (s.charAt(l) == 'W' && s.charAt(r) == 'B') {
                currCnt--;
                cnt = Math.min(currCnt, cnt);
            } else if (s.charAt(l) == 'B' && s.charAt(r) == 'W') {
                currCnt++;
                cnt = Math.min(currCnt, cnt);
            }
            l++;
            r++;
        }

        return cnt;
    }
}