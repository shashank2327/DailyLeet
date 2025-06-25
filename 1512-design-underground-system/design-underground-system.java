class Pair {
    String station;
    int start;

    public Pair(String station, int start) {
        this.station = station;
        this.start = start;
    }
}

class UndergroundSystem {
    
    Map<Integer, Pair> idToTime; 
    Map<List<String>, int[]> stations;

    public UndergroundSystem() {
        idToTime = new HashMap<>();
        stations = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        idToTime.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair it = idToTime.get(id);
        idToTime.remove(id);
        String startPoint = it.station;
        int startTime = it.start;
        List<String> srcToDst = Arrays.asList(startPoint, stationName);
        stations.putIfAbsent(srcToDst, new int[]{0, 0});
        int[] token = stations.get(srcToDst);
        token[0] += t - startTime;
        token[1]++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<String> srcToDst = Arrays.asList(startStation, endStation);
        int[] token = stations.get(srcToDst);
        double result = (double)token[0] / (double)token[1];
        return result;
    }
}

// id -> check IN ---> check out;

// station1 --> station2 ==> average time;


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */