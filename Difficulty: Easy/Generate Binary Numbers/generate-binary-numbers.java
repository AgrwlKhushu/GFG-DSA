class Solution {
    public ArrayList<String> generateBinary(int n) {
        // code here
        
        ArrayList<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while (result.size() < n) {
            String s = q.poll();
            result.add(s);
            q.add(s + "0");
            q.add(s + "1");
        }
        return result;
    }
}
