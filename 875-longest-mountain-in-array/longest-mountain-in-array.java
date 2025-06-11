class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            // check whether it is a peak element;
            if (arr[i] > arr[i - 1] && arr[i + 1] < arr[i]) {
                // go left until you can;
                int j = i;
                int size = 0;
                while (j > 0 && arr[j] > arr[j - 1]) j--;
                size += i - j;

                // go right
                j = i;
                while (j < n - 1 && arr[j] > arr[j + 1]) j++;
                size += j - i + 1;
                max = Math.max(max, size);
            }
        }
        return max;
    }
}
// possible peak of mountain --> i = 1 to i = n - 2;