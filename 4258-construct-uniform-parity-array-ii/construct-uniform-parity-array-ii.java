class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int num: nums1) {
            if (num % 2 == 0) {
                minEven = Math.min(minEven, num);
            } else {
                minOdd = Math.min(minOdd, num);
            }
        }

        if (minEven == Integer.MAX_VALUE || minOdd == Integer.MIN_VALUE) {
            return true;
        }

        if (minEven < minOdd && minOdd != Integer.MAX_VALUE) {
            return false;
        }

        return true;


    }
}

/*
I need to find the smallest odd, 
or what is the smallest odd I can make;

If the smallest number is even? -> you have to make every number even;
If the smallest number is odd? -> you have to make every number odd;
*/