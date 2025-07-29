class Solution {
    public ArrayList<Integer> asciirange(String s) {
        int n = s.length();
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> last = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!first.containsKey(c)) {
                first.put(c, i);
            }
            last.put(c, i);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (char c : first.keySet()) {
            int start = first.get(c);
            int end = last.get(c);

            if (start != end && end - start > 1) {
                int sum = 0;
                for (int i = start + 1; i < end; i++) {
                    sum += (int) s.charAt(i);
                }
                if (sum != 0) result.add(sum);
            }
        }

        return result;
    }
}
