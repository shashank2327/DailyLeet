class Solution {
    public int minSensors(int n, int m, int k) {
        int sensorCover = 2*k + 1;
        int x = n / sensorCover + (n % sensorCover == 0 ? 0 : 1);
        int y = m / sensorCover + (m % sensorCover == 0 ? 0 : 1);

        int numberOfSensors = x * y;
        return numberOfSensors;
    }
}