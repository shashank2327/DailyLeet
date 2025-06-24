class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n + 1];
        int[] suffixMax = new int[n + 1];

        prefixMax[0] = 0;
        for (int i = 0; i < n; i++) {
            prefixMax[i + 1] = Math.max(prefixMax[i], height[i]);
        }

        suffixMax[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }

        int waterAmount = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i + 1];
            int minHeight = Math.min(leftMax, rightMax);
            if (minHeight > height[i]) {
                waterAmount += minHeight - height[i];
            } 
        }

        return waterAmount;
    }
}