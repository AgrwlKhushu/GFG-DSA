class Solution {
    public int maxPeople(int[] arr) {
        // code here
        
        int n = arr.length;
        int[] prev = new int[n];
        java.util.Arrays.fill(prev, -1);
        java.util.Stack<Integer> st = new java.util.Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) prev[i] = st.peek();
            st.push(i);
        }
        int[] nextg = new int[n];
        java.util.Arrays.fill(nextg, n);
        st = new java.util.Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) nextg[i] = st.peek();
            st.push(i);
        }
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int leftBound = (prev[i] == -1 ? 0 : prev[i] + 1);
            int rightBound = (nextg[i] == n ? n - 1 : nextg[i] - 1);
            int count = rightBound - leftBound + 1;
            if (count > maxCount) maxCount = count;
        }
        return maxCount;
    }
}
