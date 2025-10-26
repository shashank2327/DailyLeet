class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int maxVal = num * 9;

        if (maxVal < sum) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int val = Math.min(9, sum);
            sum -= val;
            sb.append(val);
        }

        return sb.toString();
    }
}