class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] % k;
            if (arr[i] < 0) arr[i] += k;
        }
        Arrays.sort(arr);
        int i = 0;
        while (i < n && arr[i] == 0) {
            i++;
        }

        if (i % 2 != 0) {
            return false;
        }
        int l = i;
        int r = n - 1;
        while (l < r) {
            if (arr[l] + arr[r] != k) {
                return false;
            }    
            l++;
            r--;
        }
        return true;
    }
}