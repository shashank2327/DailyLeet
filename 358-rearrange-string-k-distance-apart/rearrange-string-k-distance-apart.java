class Solution {
    public String rearrangeString(String s, int k) {
        int[][] freq = new int[26][2];
        int uniqueCnt = 0;

        for (char ch: s.toCharArray()) {
            if (freq[ch - 'a'][1] == 0) uniqueCnt++;

            freq[ch - 'a'][0] = ch -'a';
            freq[ch - 'a'][1]++;
        }

        if (uniqueCnt < k) return "";

        Arrays.sort(freq, (a, b) -> Integer.compare(b[1], a[1]));

        // for (int[] it: freq) {
        //     System.out.println(Arrays.toString(it));
        // }

        // ch, freq, idx
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(b[1], a[1]);
        });
        int ix = 1;
        for (int[] it: freq) {
            if (it[1] > 0) {
                q.offer(new int[]{it[0], it[1], ix});
                ix++;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        int currIdx = 1;
        while (!q.isEmpty()) {
            int[] it = q.poll();

            System.out.print(Arrays.toString(it));

            int idx = it[0];
            int f = it[1] - 1;
            int pos = it[2];

            if (pos < currIdx) {
                q.offer(new int[]{idx, f + 1, currIdx});
                continue;
            }

            sb.append((char) (idx + 'a'));

            if (f > 0) {
                if (q.size() >= k - 1) {
                    q.offer(new int[]{idx, f, currIdx + k});
                } else {
                    return "";
                }
            }

            currIdx++;
        }

        return sb.toString();
    }
}