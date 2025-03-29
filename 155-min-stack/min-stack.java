class MinStack {

    PriorityQueue<Integer> pq;
    Stack<Integer> st;

    // constructor
    public MinStack() {
        st = new Stack<>();
        pq = new PriorityQueue<>();
    }
    

    //func1
    public void push(int val) {
        st.push(val);
        pq.add(val);
    }
    

    // func2
    public void pop() {
        int val = st.peek();
        pq.remove(val);
        st.pop();
    }
    
    // func3
    public int top() {
        return st.peek();
    }
    

    // func4
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */