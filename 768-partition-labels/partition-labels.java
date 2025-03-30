class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        int maxIdx = 0;
        int prevIdx = -1;
        for (int i = 0; i < n; i++) {
            maxIdx = Math.max(maxIdx, map.get(s.charAt(i)));
            if (maxIdx == i) {
                ans.add(i - prevIdx);
                prevIdx = i;
            }
        }

        return ans;
    }
}