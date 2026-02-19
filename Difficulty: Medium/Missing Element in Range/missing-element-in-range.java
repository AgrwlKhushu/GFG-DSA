class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        
        java.util.HashSet<Integer> s = new java.util.HashSet<>();
        for(int x : arr) s.add(x);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=low; i<=high; i++) {
            if(!s.contains(i)) res.add(i);
        }
        return res;
    }
}