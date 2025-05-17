class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> seen = new HashSet<>();
        for (String s : deadends) seen.add(s);
        if (seen.contains("0000")) return -1;

        Map<Character, List<Character>> turnMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            char curr = (char)(i + '0');
            int  next = i + 1 == 10 ? 0 : i + 1;
            int prev = i - 1 < 0 ? 9 : i - 1;
            turnMap.put(curr, List.of((char)(next + '0'), (char)(prev + '0')));
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        seen.add("0000");

        int turns = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) return turns;

                char[] currArr = curr.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char currNum = currArr[j];
                    for (char val : turnMap.get(currNum)) {
                        currArr[j] = val;
                        String newState = new String(currArr);
                        if (!seen.contains(newState)) {
                            queue.add(newState);
                            seen.add(newState);
                        }
                    }
                    currArr[j] = currNum;
                }
            }
            turns++;
        }

        return -1;
    }
}