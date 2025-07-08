import java.util.*;

class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        HashMap<Integer, Integer> freq = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            int currFreq = freq.get(curr);

            while (!stack.isEmpty() && freq.get(stack.peek()) <= currFreq) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result.set(i, stack.peek());
            }

            stack.push(curr);
        }

        return result;
    }
}
