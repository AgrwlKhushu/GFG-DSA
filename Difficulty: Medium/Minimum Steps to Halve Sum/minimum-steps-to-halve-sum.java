class Solution {
    public int minOperations(int[] arr) {
        // code here
        
        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        for (int num : arr) {
            sum += num;
            pq.offer((double) num);
        }
        double target = sum / 2;
        int ops = 0;
        while (sum > target) {
            double largest = pq.poll();
            double half = largest / 2;
            sum -= (largest - half);
            pq.offer(half);
            ops++;
        }
        return ops;
    }
}