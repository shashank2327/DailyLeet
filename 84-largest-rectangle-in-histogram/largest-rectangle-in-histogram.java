class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> st = new Stack<>();
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int start = i;
            while (!st.isEmpty() && st.peek()[1] > heights[i]) {
                int[] top = st.pop();
                int idx = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - idx));
                start = idx;
            }
            st.push(new int[]{start, heights[i]});
        }

        for (int[] pair : st) {
            maxArea = Math.max(maxArea, pair[1]*(n-pair[0]));
        }

        return maxArea;
    }
}