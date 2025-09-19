class Solution {
    public int minParentheses(String s) {
        // code here
        
        int open = 0, add = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else {
                if (open > 0) open--;
                else add++;
            }
        }
        return open + add;
    }
}
