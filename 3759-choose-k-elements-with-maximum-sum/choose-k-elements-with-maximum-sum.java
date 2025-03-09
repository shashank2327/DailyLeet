class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] mat = new int[n][3];
        for (int i = 0; i < n; i++) {
            mat[i][1] = i;
            mat[i][0] = nums1[i];
            mat[i][2] = nums2[i];
        }

        Arrays.sort(mat, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        long[] ans = new long[n];
        ans[mat[0][1]] = 0;
        long sum = mat[0][2];
        pq.add(mat[0][2]);
        int cnt = 1;

        for (int i = 1; i < n; i++) {

            ans[mat[i][1]] = sum;

            if (mat[i][0] == mat[i - 1][0]) {
                ans[mat[i][1]] = ans[mat[i - 1][1]];
                if (cnt < k) {
                    sum += mat[i][2];
                    pq.add(mat[i][2]);
                    cnt++;
                } else {
                    if (pq.peek() < mat[i][2]) {
                        sum = sum - pq.poll() + mat[i][2];
                        pq.add(mat[i][2]);
                    }
                }
            
            } else {
                if (cnt < k) {
                    sum += mat[i][2];
                    pq.add(mat[i][2]);
                    cnt++;
                } else {
                    if (pq.peek() < mat[i][2]) {
                        sum = sum - pq.poll() + mat[i][2];
                        pq.add(mat[i][2]);
                    }
                }
                
            }
        }

        return ans;
    }
}