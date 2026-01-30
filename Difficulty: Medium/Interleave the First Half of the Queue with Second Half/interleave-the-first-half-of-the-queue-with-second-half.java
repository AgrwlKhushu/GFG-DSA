class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        
        int n = q.size();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = q.poll();
        }
        
        for (int i = 0; i < n / 2; i++) {
            q.add(arr[i]);
            q.add(arr[i + n / 2]);
        }
    }
}
