class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        permutation(0, s, result, "");
        return result;
    }

    public void permutation(int idx, String s, List<String> result, String str) {
        if (idx == s.length()) {
            result.add(str);
            return;
        }

        char ch = s.charAt(idx);

        if (ch >= 'a' && ch <= 'z') {
            permutation(idx + 1, s, result, str + Character.toUpperCase(ch));
        }

        if (ch >= 'A' && ch <= 'Z') {
            permutation(idx + 1, s, result, str + Character.toLowerCase(ch));
        }

        permutation(idx + 1, s, result, str + ch);
    }
}