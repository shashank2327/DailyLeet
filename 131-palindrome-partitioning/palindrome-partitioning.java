class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        fun(s, 0, -1, "", new ArrayList<>(), res);
        return res;
    }   

    private void fun(
        String s,
        int i,
        int j,
        String t,
        List<String> temp,
        List<List<String>> res
    ) {
        if (i >= s.length()) {
            if (t.equals(s)) {
                res.add(new ArrayList<>(temp));
            }  
            return;
        }

        String str = s.substring(j + 1, i + 1);
        if (check(str)) {
            temp.add(str);
            fun(s, i + 1, i, t + str, temp, res);
            temp.remove(temp.size() - 1);
        }
        
        fun(s, i + 1, j, t, temp, res);    
    }

    private boolean check(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}