class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int maxIdx = 0;
        int prevIdx = -1;
        for (int i = 0; i < n; i++) {
            maxIdx = Math.max(maxIdx, freq[s.charAt(i) - 'a']);
            if (maxIdx == i) {
                ans.add(i - prevIdx);
                prevIdx = i;
            }
        }

        return ans;
    }
}