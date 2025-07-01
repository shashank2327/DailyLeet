class Solution {
    public int possibleStringCount(String word) {
        List<Integer> ls = new ArrayList<>();
        int n = word.length();
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                cnt++;
            } else {
                ls.add(cnt);
                cnt = 1;
            }
        }
        ls.add(cnt);
        int result = 0;
        for (int val : ls) {
            if (val == 1) continue;
            result += val - 1;
        }

        return result + 1;
    }
}