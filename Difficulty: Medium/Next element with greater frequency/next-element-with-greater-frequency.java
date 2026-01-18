class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        // code here
        
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && freq.get(st.peek()) <= freq.get(arr[i])) {
                st.pop();
            }
            result.add(st.isEmpty() ? -1 : st.peek());
            st.push(arr[i]);
        }
        Collections.reverse(result);
        return result;
    }
}