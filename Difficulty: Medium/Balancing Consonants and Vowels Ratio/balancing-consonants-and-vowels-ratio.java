class Solution {
    public int countBalanced(String[] arr) {
        Map<Integer, Integer> balanceFreq = new HashMap<>();
        int balance = 0;
        int result = 0;
        balanceFreq.put(0, 1); // Base case for empty prefix

        for (String s : arr) {
            int vowels = 0, consonants = 0;
            for (char c : s.toCharArray()) {
                if (isVowel(c)) vowels++;
                else consonants++;
            }

            balance += (vowels - consonants);

            result += balanceFreq.getOrDefault(balance, 0);
            balanceFreq.put(balance, balanceFreq.getOrDefault(balance, 0) + 1);
        }

        return result;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}