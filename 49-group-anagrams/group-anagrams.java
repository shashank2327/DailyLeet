class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            String sorted = sortString(s);
            System.out.println(sorted);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }

        for (List<String> ls: map.values()) {
            res.add(ls);
        }

        return res;
    }

    private String sortString(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();

        for (char ch: a) {
            sb.append(ch);
        }

        return sb.toString();
    }
}

/*
    the brute force approach is to compare every pair and check whether
    they are anagram or not;

    O(n2) - TC


    ate, bat, eat, nat, tan, tea
*/