class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();


        for (int i = n - 2; i >= 0; i--) {
            st.push(nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            int val = nums[i];

            while (!st.isEmpty() && st.peek() <= val) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }

            st.push(val);
        }

        return res;
    }
}