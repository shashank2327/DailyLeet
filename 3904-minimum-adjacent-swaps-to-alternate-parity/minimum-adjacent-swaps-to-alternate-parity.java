class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int oddCnt = 0, evenCnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                evenCnt++;
                nums[i] = 0;
            } else {
                oddCnt++;
                nums[i] = 1;
            }
        }

        if (Math.abs(oddCnt - evenCnt) > 1) return -1;

        if (evenCnt == oddCnt) {
            int[] a = nums.clone();
            return Math.min(cntSwaps(nums), cntSwaps2(a));
        }

        if (evenCnt < oddCnt) {
            return cntSwaps2(nums);
        } else {
            return cntSwaps(nums);
        }

    }

    private int cntSwaps(int[] nums) {
        // at every even index there should be 0;
        // and at every odd index there should be 1;
        int n = nums.length;
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j == i) j++;
            if (i % 2 == 0 && nums[i] != 0) {
                for (int k = j; k < n; k++) {
                    if (nums[k] == 0) {
                        swap(nums, i, k);
                        cnt += k - i;
                        j = k;
                        break;
                    }
                }
            }
            if (i % 2 == 1 && nums[i] != 1) {
                for (int k = j; k < n; k++) {
                    if (nums[k] == 1) {
                        cnt += k - i;
                        j = k;
                        swap(nums, i, k);
                        break;

                    }
                }
            }
        }

        return cnt;
    }

    private int cntSwaps2(int[] nums) {
        // at every even index there should be 0;
        // and at every odd index there should be 1;
        int n = nums.length;
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j == i) j++;
            if (i % 2 == 0 && nums[i] != 1) {
                for (int k = j; k < n; k++) {
                    if (nums[k] == 1) {
                        swap(nums, i, k);
                        cnt += k - i;
                        j = k;
                        break;
                    }
                }
            }
            if (i % 2 == 1 && nums[i] != 0) {
                for (int k = j; k < n; k++) {
                    if (nums[k] == 0) {
                        cnt += k - i;
                        swap(nums, i, k);
                        j = k;
                        break;
                    }
                }
            }
        }

        return cnt;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}