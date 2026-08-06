class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            while (map.size() > 2 && left <= i) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}