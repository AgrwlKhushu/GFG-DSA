class Solution {
    public static boolean checkRedundancy(String s) {
        // code here
        
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == ')'){
                boolean flag = true;
                while(!st.isEmpty() && st.peek() != '('){
                    char top = st.pop();
                    if(top == '+' || top == '-' || top == '*' || top == '/'){
                        flag = false;
                    }
                }
                if(flag) return true;
                if(!st.isEmpty()) st.pop();
            } else {
                st.push(ch);
            }
        }
        return false;
    }
}
