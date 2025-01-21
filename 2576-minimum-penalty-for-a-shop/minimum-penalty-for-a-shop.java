class Solution {
    public int bestClosingTime(String customers) {
        // brute force ->
        // Run two loops, calculate penalty for each hour, return the min.
        // TLE , Since n = 1e5;

        int n = customers.length();
        int yesCt = 0;
        for (char ch : customers.toCharArray()) {
            if (ch == 'Y') yesCt++;
        }
        int nCt = 0;
        
        int min = Integer.MAX_VALUE;
        int ind = -1;
        for (int i = 0; i < n; i++) {
            int penalty = 0;
            if (customers.charAt(i) == 'Y') {
                penalty += yesCt + nCt;
                yesCt--;
            } else if (customers.charAt(i) == 'N') {
                penalty += yesCt + nCt;
                nCt++;
            }


            if (penalty < min) {
                min = penalty;
                ind = i;
            }
        }

        if (nCt < min) {
            ind = n;
        }

        return ind;
    }
}