class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int count = 0;
        for (int num :nums) {
            if (num < pivot) {
                smaller.add(num);
            } else if (num == pivot) {
                count++;
            } else {
                greater.add(num);
            }
        }
        int i = 0;
        while (!smaller.isEmpty()) {
            int val = smaller.get(0);
            nums[i] = val;
            i++;
            smaller.remove(0);
        }

        while (count != 0) {
            nums[i] = pivot;
            i++;
            count--;
        }

        while (!greater.isEmpty()) {
            nums[i] = greater.get(0);
            i++;
            greater.remove(0);
        }

        return nums;
    }
}