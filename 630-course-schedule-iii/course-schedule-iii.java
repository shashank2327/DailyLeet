class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        List<Integer> ls = new ArrayList<>();

        int time = 0;
        for (int[] c : courses) {
            if (time + c[0] <= c[1]) {
                ls.add(c[0]);
                time += c[0];
            } else {
                int max_i = 0;
                for (int i = 1; i < ls.size(); i++) {
                    if (ls.get(i) > ls.get(max_i)) {
                        max_i = i;
                    }
                }

                if (ls.size() > 0 && ls.get(max_i) > c[0]) {
                    time += c[0] - ls.get(max_i);
                    ls.set(max_i, c[0]);
                }
            }
        }

        return ls.size();
    }
}

/*
100   200
1000 1250
200  1300
2000 3200
*/