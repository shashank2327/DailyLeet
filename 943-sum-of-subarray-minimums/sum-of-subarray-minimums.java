class Solution {
    private final int MOD = (int)1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        int[] ns = nse(arr);
        int[] ps = pse(arr);
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            long left = i - ps[i];
            long right = ns[i] - i;
            res = (res + (left*right*arr[i])%MOD)%MOD;
        }
        return (int)res;
    }

    private int[] nse(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ns = new int[n];

        for (int i = n - 1;i >= 0; i--) {
            int nsmall =  n;
            while (!st.isEmpty()) {
                if (nums[st.peek()] < nums[i]) {
                    nsmall = st.peek();
                    break;
                }
                st.pop();
            }
            st.push(i);
            ns[i] = nsmall;
        }

        return ns;
    }

    private int[] pse(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ps = new int[n];

        for (int i = 0; i < n; i++) {
            int psmall = -1;
            while (!st.isEmpty()) {
                if (nums[st.peek()] <= nums[i]) {
                    psmall = st.peek();
                    break;
                }
                st.pop();
            }
            st.push(i);
            ps[i] = psmall;
        }
        return ps;
    }
}