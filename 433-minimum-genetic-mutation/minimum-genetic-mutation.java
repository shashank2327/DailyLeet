class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int n = bank.length;
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        seen.add(startGene);
        int level = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                String gene = q.poll();
                if (gene.equals(endGene)) return level;

                for (int i = 0; i < n; i++) {
                    if (!seen.contains(bank[i]) && checkValidMutation(bank[i], gene)) {
                        seen.add(bank[i]);
                        q.offer(bank[i]);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private boolean checkValidMutation(String s1, String s2) {
        int cnt = 0; // number of different Characters;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1 ? true : false;
    }
}