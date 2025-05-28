class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        if (!second.isEmpty()) {
            return second.pop();
        } else {
            while (!first.isEmpty()) {
                int val = first.pop();
                second.push(val);
            }
            return second.pop();
        }
    }
    
    public int peek() {
        if (!second.isEmpty()) {
            return second.peek();
        } else {
            while (!first.isEmpty()) {
                int val = first.pop();
                second.push(val);
            }
            return second.peek();
        }
    }
    
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */