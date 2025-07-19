class Solution {
    public int vowelCount(String s) {
        Map<Character, List<Integer>> vowelPositions = new HashMap<>();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (vowels.contains(ch)) {
                vowelPositions.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
            }
        }

        if (vowelPositions.size() == 0) return 0;

        int combinations = 1;
        for (List<Integer> positions : vowelPositions.values()) {
            combinations *= positions.size();
        }

        int permutations = factorial(vowelPositions.size());
        return combinations * permutations;
    }

    private int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
}
