class Solution {
    public String removeKdig(String s, int k) {
        // code here
        
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        int i = 0;
        while (i < stack.length() && stack.charAt(i) == '0') {
            i++;
        }
        String result = stack.substring(i);
        return result.isEmpty() ? "0" : result;
    }
}