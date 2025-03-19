class Solution {
    public int minOperations(int[] a) {
        int n = a.length;
        int i = 0;
        int cnt = 0;
        while (i < n - 2) {
            if (a[i] == 0) {
                a[i] = 1;
                a[i + 1] = a[i + 1] ^ 1;
                a[i + 2] = a[i + 2] ^ 1;
                cnt++;
            }
            i++;
        }

        boolean flag = false;

        for (int num : a) {
            if (num == 0) {
                flag = true;
                break;
            }
        }

        if (flag) {
            return -1;
        } else {
            return cnt;
        }
    }
}