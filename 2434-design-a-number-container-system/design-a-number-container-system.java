class NumberContainers {

    private Map<Integer, TreeSet<Integer>> numToind;
    private Map<Integer, Integer> indTonum;

    public NumberContainers() {
        numToind = new HashMap<>();
        indTonum = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (indTonum.containsKey(index)) {
            int prevNum = indTonum.get(index);
            numToind.get(prevNum).remove(index);
            if (numToind.get(prevNum).isEmpty()) {
                numToind.remove(prevNum);
            }
        }
        indTonum.put(index, number);
        numToind.putIfAbsent(number, new TreeSet<>());
        numToind.get(number).add(index);
    }
    
    public int find(int number) {
        if (numToind.containsKey(number)) {
            return numToind.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */