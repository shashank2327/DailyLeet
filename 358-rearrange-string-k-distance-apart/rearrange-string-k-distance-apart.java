class Solution {
    public String rearrangeString(String s, int k) {
        if (k > 26) return "";
        
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

/*

class Solution {
    public String rearrangeString(String s, int k) {
        // build frequencies mapping
        int[] frequencies = new int[26];
        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }

        // create max heap of [character, its frequency]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; ++i) {
            if (frequencies[i] != 0) maxHeap.add(new int[]{i, frequencies[i]});
        }

        // cooling queue [char, it frequency]
        Queue<int[]> coolingQueue = new ArrayDeque<>();

        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();

            // append to result and add to cooling queue (even if freq = 0)
            res.append((char) (cur[0] + 'a'));
            cur[1]--;

            coolingQueue.add(cur);

            // add back to heap after k positions passed
            if (coolingQueue.size() >= k) {
                int[] release = coolingQueue.poll();
                if (release[1] > 0) maxHeap.add(release);
            }
        }

        return res.length() < s.length() ? "" : res.toString();
    }
}

*/