class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        fun(s, 0, new ArrayList<>(), res);
        return res;
    }
    public void fun(String s, int startIdx, List<String> temp, List<List<String>> res) {
        
        if (startIdx == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = startIdx; i < s.length(); i++) {
            String subStr = s.substring(startIdx, i + 1);
            if (isPalindrome(subStr)) {
                temp.add(subStr);
                fun(s, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
            
        }
    }

    // sIdx = 0; ->> n "aab" -> a [0, 1) [1,)


    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}