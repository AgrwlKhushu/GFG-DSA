class Solution {
    public static int sumSubstrings(String s) {
        long res = 0;
        long prevSum = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            prevSum = prevSum * 10 + (long) digit * (i + 1);
            res += prevSum;
        }

        return (int) res;
    }
}
