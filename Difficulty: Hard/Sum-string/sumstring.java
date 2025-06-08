class Solution {
    public boolean isSumString(String s) {
        int n = s.length();
        
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= (n - i); j++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, i + j);
                
                if (isValid(s1) && isValid(s2)) {
                    if (check(s1, s2, s.substring(i + j))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isValid(String str) {
        return !(str.length() > 1 && str.startsWith("0"));
    }

    private boolean check(String s1, String s2, String remaining) {
        String sum = addStrings(s1, s2);

        if (remaining.length() < sum.length() || !remaining.startsWith(sum)) {
            return false;
        }

        if (remaining.equals(sum)) return true;

        return check(s2, sum, remaining.substring(sum.length()));
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = n1 + n2 + carry;

            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}
