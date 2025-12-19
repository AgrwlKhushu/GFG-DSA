class Solution {
    public int findMoves(int[] chairs, int[] passengers) {
        // code here
        
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        int n = chairs.length;
        long moves = 0;
        for (int i = 0; i < n; i++) {
            moves += Math.abs(chairs[i] - passengers[i]);
        }
        return (int)moves;
    }
}
