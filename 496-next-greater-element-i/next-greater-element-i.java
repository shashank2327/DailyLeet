class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            int val = -1;
            while (!st.isEmpty()) {
                if (st.peek() > nums2[i]) {
                    val = st.peek();
                    break;
                }
                st.pop();
            }
            nge[i] = val;
            st.push(nums2[i]);
            map.put(nums2[i], i);
        }
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int val = nums1[i];
            result[i] = nge[map.get(val)];
        }

        return result;
    }
}