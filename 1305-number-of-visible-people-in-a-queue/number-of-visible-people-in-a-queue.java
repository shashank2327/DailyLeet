class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int cnt = 0;
            if (st.isEmpty()) {
                st.push(heights[i]);
                res[i] = 0;
            } else {
                int currHeight = heights[i];
                while (!st.isEmpty()) {
                    int rightHeight = st.peek();
                    if (rightHeight < currHeight) {
                        cnt++;
                        st.pop();
                    } else {
                        cnt++;
                        break;
                    }
                }
                st.push(currHeight);
                res[i] = cnt;
            }
        }

        return res;
    }
}