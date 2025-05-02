class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] ch = dominoes.toCharArray();
        
        int[] balance = new int[n];
        
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'R') {
                force = n;
            } else if (ch[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }

            balance[i] += force;
        }

        force = 0;
        for (int i = n-1; i >= 0; i--) {
            if (ch[i] == 'L') force = n;
            else if (ch[i] == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            balance[i] -= force;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : balance) {
            sb.append(num > 0 ? 'R' : num < 0 ? 'L' : '.');
        }

        return sb.toString();
    }
}