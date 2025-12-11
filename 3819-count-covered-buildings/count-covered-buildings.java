class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[][] xToy = new int[n + 1][2];
        int[][] yTox = new int[n + 1][2];

        for (int[] row : xToy) {
            row[0] = Integer.MAX_VALUE;
        }
        for (int[] row : yTox) {
            row[0] = Integer.MAX_VALUE;
        }

        for (int[] cordi : buildings) {
            int x = cordi[0];
            int y = cordi[1];

            xToy[x][0] = Math.min(xToy[x][0], y);
            xToy[x][1] = Math.max(xToy[x][1], y);

            yTox[y][0] = Math.min(yTox[y][0], x);
            yTox[y][1] = Math.max(yTox[y][1], x);
        }

        int count = 0;
        for (int[] cordi : buildings) {
            int x = cordi[0];
            int y = cordi[1];

            boolean firstCheck = (x > yTox[y][0]) && (x < yTox[y][1]) ? true : false;
            boolean secondCheck = (y > xToy[x][0]) && (y < xToy[x][1]) ? true : false;

            if (firstCheck && secondCheck) {
                count++;
            }
        }

        return count;
    }   
}

/*
    for every x point what is the maximum y point and minimum y point
    similarly,
    for every y point what is the maximum x point and minimum x point
*/
