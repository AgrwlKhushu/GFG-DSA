class Solution {
    public static String caseSort(String s) {
        // code here
        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upper.add(c);
            } else {
                lower.add(c);
            }
        }

        Collections.sort(upper);
        Collections.sort(lower);

        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(upper.get(i++));
            } else {
                result.append(lower.get(j++));
            }
        }

        return result.toString();
    }
}