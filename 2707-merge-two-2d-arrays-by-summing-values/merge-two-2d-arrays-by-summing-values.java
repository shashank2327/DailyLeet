class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        ArrayList<int[]> list = new ArrayList<>();
        int[] f = new int[1001];

        for (int i = 0; i < nums1.length; i++) {
            f[nums1[i][0]] += nums1[i][1];
        }

        for (int i = 0; i < nums2.length; i++) {
            f[nums2[i][0]] += nums2[i][1];
        }

        for (int i = 0; i <= 1000;i++) {
            if (f[i] != 0) {
                list.add(new int[]{i, f[i]});
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}