class Solution {
    public String longestString(String[] words) {
        // code here
        Arrays.sort(words);

        Set<String> validWords = new HashSet<>();
        String result = "";

        for (String word : words) {
            if (word.length() == 1 || validWords.contains(word.substring(0, word.length() - 1))) {
                validWords.add(word);

                if (word.length() > result.length() ||
                    (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }

        return result;
    }
}
