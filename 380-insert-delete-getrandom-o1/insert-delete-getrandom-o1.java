class RandomizedSet {

    Random random;
    HashMap<Integer, Integer> valToIndex;
    Integer[] arr;
    int idx;

    public RandomizedSet() {
        random = new Random();
        valToIndex = new HashMap<>();
        arr = new Integer[200001];
        idx = 0;
    }
    
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        } else {
            valToIndex.put(val, idx);
            arr[idx] = val;
            idx++;
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (valToIndex.containsKey(val)) {
            int i = valToIndex.get(val);
            arr[i] = null;
            idx--;
            arr[i] = arr[idx];
            arr[idx] = null;
            valToIndex.remove(val);
            valToIndex.put(arr[i] , i);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        int randomIdx = random.nextInt(0, idx);
        return arr[randomIdx];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */