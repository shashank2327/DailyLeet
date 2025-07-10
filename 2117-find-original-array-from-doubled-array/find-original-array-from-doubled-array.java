class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[]{};

        int[] freq = new int[100001];
        for (int num : changed) {
            freq[num]++;
        }

        int[] result = new int[n / 2];
        List<int[]> ls = new ArrayList<>();
        int idx = 0;
        for (int i = 1; i <= 100000; i++) {
            if (freq[i] == 0) continue;

            if (2 * i <= 100000 && freq[2 * i] >=  freq[i]) {
                ls.add(new int[]{i, freq[i]});
                freq[2 * i] -= freq[i];
                freq[i] = 0;
                
            }
        }

        if (freq[0] % 2 == 0) {
            ls.add(new int[]{0, freq[0] / 2});
            freq[0] = 0;
        } else {
            return new int[]{};
        }

        for (int i = 0; i <= 100000; i++) {
            if (freq[i] != 0) {
                return new int[]{};
            }
        }

        for (int j = 0; j < ls.size(); j++) {
            int val = ls.get(j)[0];
            for (int k = 0; k < ls.get(j)[1]; k++) {
                result[idx++] = val;
            }
        }

        return result;
    }
}

/*
[2, 2, 4, 4, 3, 6];

2 -> 2;
3 -> 1;
4 -> 2;
6 -> 1;

*/