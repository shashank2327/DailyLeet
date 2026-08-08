class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        
        int min = 300002;
        int idx1 = 600000;
        int idx2 = 300001;

        for (int i = 0; i < wordsDict.length; i++) {
            boolean f1 = word1.equals(wordsDict[i]);
            boolean f2 = word2.equals(wordsDict[i]);

            if (f1) {
                min = Math.min(Math.abs(idx1 - idx2), min);
                idx1 = i;
            }

            if (f2) {
                min = Math.min(Math.abs(idx1 - idx2), min);
                idx2 = i;
            }
        }

        min = Math.min(Math.abs(idx1 - idx2), min);

        return min;
    }
}