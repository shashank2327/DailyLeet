class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 2; i >= 0; i--) {
            st.push(nums[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            int val = -1;
            while (!st.isEmpty()) {
                if (st.peek() > nums[i]) {
                    val = st.peek();
                    break;
                }
                st.pop();
            }
            nge[i] = val;
            st.push(nums[i]);
        }
        return nge;
    }
}