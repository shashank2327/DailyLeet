class Solution {
    public int minLengthAfterRemovals(String s) {
        int aCount = 0;
        int bCount = 0;
        int removed = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                aCount++;
            } else if (ch == 'b') {
                bCount++;
            } else {
                removed += 2 * Math.min(aCount, bCount);
                aCount = 0;
                bCount = 0;
            }
        }
        removed += 2 * Math.min(aCount, bCount);

        return s.length() - removed;
    }
}