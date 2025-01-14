class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n + 1];
        int[] C = new int[n];
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int val1 = A[i];
            int val2 = B[i];
            freq[val1]++;
            freq[val2]++;
            int count = 0;
            if (val1 != val2) {
                if (freq[val1] == 2) count++;
                if (freq[val2] == 2) count++;
            } else {
                if (freq[val1] == 2) {
                    count++;
                }
            }
            
            C[i] = count + prev;
            prev = C[i];
        }
        return C;
    }
}