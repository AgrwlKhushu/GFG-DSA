class Solution {
    public int findLength(int[] color, int[] radius) {
        // code here
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < color.length; i++) {
            int[] current = new int[]{color[i], radius[i]};
            
            if (!stack.isEmpty() &&
                stack.peek()[0] == current[0] &&
                stack.peek()[1] == current[1]) {
                stack.pop(); 
            } else {
                stack.push(current); 
            }
        }

        return stack.size();
    }
}