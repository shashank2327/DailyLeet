class Solution {
    public int maxBalancedShipments(int[] weight) {
        int n = weight.length;
        int count = 0;
        int i = 1;
        while (i < n) {
            if (weight[i] < weight[i - 1]) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count;
    }
}