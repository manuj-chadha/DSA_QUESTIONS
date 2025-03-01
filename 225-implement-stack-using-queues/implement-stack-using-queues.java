class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue=new LinkedList<>();
    }
    
    public void push(int x) {
        int size=queue.size();
        queue.offer(x);
        for(int i=0;i<size;i++){
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        if(empty()) throw new RuntimeException("Stack is empty.");
        return queue.poll();
    }
    
    public int top() {
        if(empty()) throw new RuntimeException("Stack is empty.");
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */