class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length < 2) return ans;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();

            for (int j = 0; j <= len; j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);

                if (isPalindrome(word, j, len - 1)) {
                    String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                    Integer idx = map.get(reversedPrefix);
                    if (idx != null && idx != i) {
                        ans.add(Arrays.asList(i, idx));
                    }
                    
                }

                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                    Integer idx = map.get(reversedSuffix);
                    if (idx != null && idx != i) {
                        ans.add(Arrays.asList(idx, i));
                    }
                }
            }
        }

        return ans;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}