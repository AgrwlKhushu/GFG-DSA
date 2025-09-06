/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        if (head == null) return 0;
        
        Node slow = head, fast = head;
        
        // Step 1: Detect loop using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                // Step 2: Loop detected, count length
                return countLoopLength(slow);
            }
        }
        
        // No loop found
        return 0;
    }
    
    private int countLoopLength(Node meetingPoint) {
        Node temp = meetingPoint;
        int count = 1;
        
        while (temp.next != meetingPoint) {
            count++;
            temp = temp.next;
        }
        
        return count;
    }
}