class Solution {
    public List<String> partitionString(String s) {
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        while (i < n) {
            String sub = s.substring(j, i + 1);
            if (!set.contains(sub)) {
                set.add(sub);
                result.add(sub);
                i++;
                j = i;
            } else {
                i++;
            }
        }

        if (j < n) {
            set.add(s.substring(j, i));
        }
        return result;
    }
}