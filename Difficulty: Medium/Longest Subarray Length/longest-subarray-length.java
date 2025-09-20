class Solution {
    public static int longestSubarray(int[] arr) {
        // code here
        
        int n = arr.length;
        int[] nextGreater = new int[n];
        int[] prevGreater = new int[n];
        Arrays.fill(nextGreater, n);
        Arrays.fill(prevGreater, -1);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                nextGreater[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                prevGreater[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int windowSize = nextGreater[i] - prevGreater[i] - 1;
            if (windowSize >= arr[i]) {
                maxLength = Math.max(maxLength, windowSize);
            }
        }
        return maxLength;
    }
}