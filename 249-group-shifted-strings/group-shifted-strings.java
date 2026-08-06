class Solution {

    String getHash(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < chars.length; i++) {
            char ch = ((char) ((chars[i] - chars[i - 1] + 26) % 26 + 'a'));
            sb.append(ch);
        }

        return sb.toString();
    }

    public List<List<String>> groupStrings(String[] strings) {

        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            String hashValue = getHash(str);

            if (map.get(hashValue) == null) {
                map.put(hashValue, new ArrayList<>());
            }

            map.get(hashValue).add(str);
        }

        for (List<String> grp: map.values()) {
            res.add(grp);
        }

        return res;
    }
}

/*
    Brute Force Approach:

    Use two loops to figure out similarity between two strings. (200 * 200)
    Comparision between two strings will take 2 * 50

    T.C.: 200 * 200 * 2 * 50 = 4000000 =  4e6;
*/

/*
 a b c d e f g h i j k l m n o p q r s t u v w x y z
*/