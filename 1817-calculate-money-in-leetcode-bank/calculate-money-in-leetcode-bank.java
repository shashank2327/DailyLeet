class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int remainingDays = n % 7;

        return sum(n) - 42 * sum(weeks - 1) - 6 * weeks * remainingDays;
    }

    private int sum(int n) {
        return (n * (n + 1)) / 2;
    }
}