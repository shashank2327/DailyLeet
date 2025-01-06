class Solution {
    public int[] minOperations(String boxes) {
    
        int n = boxes.length();
        int[] ans = new int[n];
        int ahead = 0;
        int behind = 0;
        for (int i = 0 ; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                ans[0] += i;
                ahead++;
            }
        }

        if (boxes.charAt(0) == '1') {
            ahead--;
            behind++;
        }

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] - ahead + behind;
            if (boxes.charAt(i) == '1') {
                ahead--;
                behind++;
            }
        }
        return ans; 
    }
}