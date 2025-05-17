class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        int n = routes.length;

        // Map each stop to the buses (route index) that visit it
        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, x -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();

        // Start BFS from all buses passing through the source stop
        for (int bus : stopToBuses.getOrDefault(source, new ArrayList<>())) {
            q.offer(bus);
            visitedBuses.add(bus);
        }

        int busesTaken = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int bus = q.poll();
                for (int stop : routes[bus]) {
                    if (stop == target) return busesTaken;
                    if (visitedStops.contains(stop)) continue;
                    visitedStops.add(stop);
                    for (int nextBus : stopToBuses.getOrDefault(stop, new ArrayList<>())) {
                        if (!visitedBuses.contains(nextBus)) {
                            q.offer(nextBus);
                            visitedBuses.add(nextBus);
                        }
                    }
                }
            }
            busesTaken++;
        }

        return -1;
    }
}
