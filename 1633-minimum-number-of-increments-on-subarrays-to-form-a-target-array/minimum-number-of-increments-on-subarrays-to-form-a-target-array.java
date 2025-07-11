class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int cnt = target[0];

        for (int i = 1; i < n; i++) {
            cnt += Math.max(target[i] - target[i - 1], 0);
        }

        return cnt;
    }
}