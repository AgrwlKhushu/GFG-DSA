class Solution {
    
    private StringBuilder document;
    private Stack<Character> redoStack;
    
    public Solution() {
        document = new StringBuilder();
        redoStack = new Stack<>();
    }
    
    public void append(char x) {
        // append x into document
        
        document.append(x);
        redoStack.clear();
    }

    public void undo() {
        // undo last change
        
        if (document.length() > 0) {
            char last = document.charAt(document.length() - 1);
            document.deleteCharAt(document.length() - 1);
            redoStack.push(last);
        }
    }

    public void redo() {
        // redo changes
        
        if (!redoStack.isEmpty()) {
            char ch = redoStack.pop();
            document.append(ch);
        }
    }

    public String read() {
        // read the document
        
        return document.toString();
    }
}
