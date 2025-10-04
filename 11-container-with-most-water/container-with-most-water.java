class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            max = Math.max(max, h * (r-l));
            if (h == height[l]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}