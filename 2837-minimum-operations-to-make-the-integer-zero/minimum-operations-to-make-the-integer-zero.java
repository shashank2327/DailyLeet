class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        int operationCount = 1;
        while (true) {
            long currentValue = num1 - (long) num2 * operationCount;
            if (currentValue < operationCount) {
                return -1;
            }

            if (operationCount >= Long.bitCount(currentValue)) return operationCount;

            operationCount++;
        }
    }
}