class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for (List<String> it: knowledge) {
            String key = it.get(0);
            String val = it.get(1);
            map.put(key, val);
        }

        StringBuilder res = new StringBuilder();
        int n = s.length();
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '(') {
                i++;
                StringBuilder sb = new StringBuilder();
                while (s.charAt(i) != ')') {
                    sb.append(s.charAt(i));
                    i++;
                }

                String key = sb.toString();
                if (map.containsKey(key)) {
                    res.append(map.get(key));
                } else {
                    res.append("?");
                }
            } else {
                res.append(s.charAt(i));
            }

            i++;
        }

        return res.toString();
    }
}