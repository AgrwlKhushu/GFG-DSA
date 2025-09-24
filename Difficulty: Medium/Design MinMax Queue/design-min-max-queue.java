class SpecialQueue {
    
    private Deque<Integer> queue;
    private Deque<Integer> minDeque;
    private Deque<Integer> maxDeque;

    public SpecialQueue() {
        // Define Data Structures
        
        queue = new ArrayDeque<>();
        minDeque = new ArrayDeque<>();
        maxDeque = new ArrayDeque<>();
    }

    public void enqueue(int x) {
        // Insert element into the queue
        
        queue.addLast(x);
        while (!minDeque.isEmpty() && minDeque.peekLast() > x) {
            minDeque.pollLast();
        }
        minDeque.addLast(x);
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < x) {
            maxDeque.pollLast();
        }
        maxDeque.addLast(x);
    }

    public void dequeue() {
        // Remove element from the queue
        
        int val = queue.pollFirst();
        if (val == minDeque.peekFirst()) {
            minDeque.pollFirst();
        }
        if (val == maxDeque.peekFirst()) {
            maxDeque.pollFirst();
        }
    }

    public int getFront() {
        // Get front element
        
        return queue.peekFirst();
    }

    public int getMin() {
        // Get minimum element
        
        return minDeque.peekFirst();
    }

    public int getMax() {
        // Get maximum element
        
        return maxDeque.peekFirst();
    }
}