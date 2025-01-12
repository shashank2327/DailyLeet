class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = -100000;
        arr[n + 1] = 100000;
        int count = 0;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        for (int i = 2; i <= n + 1; i++) {
            if (arr[i - 1] > arr[i]) {
                int prev = arr[i - 2];
                int after = arr[i];
                if (prev > after) {
                    arr[i] = arr[i - 1];
                } else if (prev <= after) {
                    arr[i - 1] = prev;
                }
                count++;
            }
        }

        if (count > 1) {
            return false;
        } else {
            return true;
        }
    }
}