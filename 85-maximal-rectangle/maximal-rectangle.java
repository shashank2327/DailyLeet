class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0 ; j < m ; j++) {
                dp[i][j] = matrix[i][j] - '0';
                if (matrix[i][j] != '0') {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }

        int max = -1;
        for (int[] arr : dp) {
            int area = largestRectangleArea(arr);
            max = Math.max(area, max);
        }

        return  max;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); // pair:(index, height)

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[] {start, heights[i]});
        }

        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }
}