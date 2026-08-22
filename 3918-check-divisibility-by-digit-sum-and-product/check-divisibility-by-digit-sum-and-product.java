class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int pro = 1;
        int val = n;
        while (val != 0) {
            sum += val%10;
            pro *= val%10;

            val = val / 10;
        }


        if (n % (sum + pro) == 0) {
            return true;
        } else {
            return false;
        }
    }
}