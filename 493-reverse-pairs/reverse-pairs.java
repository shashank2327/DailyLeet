class Solution {
    
    static int merge(int[] arr, int low, int mid, int high) {
        int cnt = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low; // starting idx of left half;
        int right = mid + 1; // starting idx of right half;

        // counting part;
        int j = right;
        for (int i = left; i <= mid; i++) {;
            while (j <= high) {
                if ((long)arr[i] <= 2L * (long)arr[j]) {
                    break;
                }
                j++;
            }
            cnt += j - right;
        }


        // sorting part;
        left = low;
        right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return cnt;
    }
    static int mergeSort(int[] nums, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;

        int mid = (low + high) / 2;
        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid + 1, high);
        cnt += merge(nums, low, mid, high);

        return cnt;
    }
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }
}