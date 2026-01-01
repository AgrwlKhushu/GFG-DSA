/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        
        if (head1 == null || head2 == null) return null;

        Node p1 = head1;
        Node p2 = head2;

        while (p1 != p2) {
            p1 = (p1 != null) ? p1.next : head2;
            p2 = (p2 != null) ? p2.next : head1;
        }

        return p1;
    }
}