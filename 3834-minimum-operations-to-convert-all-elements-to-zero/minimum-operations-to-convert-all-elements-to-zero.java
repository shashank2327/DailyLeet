class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int res = 0;
        for (int a : nums) {
            while (!st.isEmpty() && st.peek() > a) {
                st.pop();
            }

            if (st.isEmpty() || st.peek() < a) {
                res++;
                st.push(a);
            }
        }

        return res;
    }
}