class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n - 1];

        int waterAmount = 0;

        int l = 1;
        int r = n - 2;

        boolean flag = false;
        if (leftMax <= rightMax) {
            flag = true;
        }

        while (l <= r) {
            if (flag) {
                int water = leftMax - height[l];
                if (water > 0) waterAmount += water;
                leftMax = Math.max(leftMax, height[l]);
                l++;
            } else {
                int water = rightMax - height[r];
                if (water > 0) waterAmount += water;
                rightMax = Math.max(rightMax, height[r]);
                r--;
            }

            if (leftMax <= rightMax) {
                flag = true;
            } else {
                flag = false;
            }
        }

        return waterAmount;
    }
}