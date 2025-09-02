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
    public Node swapKth(Node head, int k) {
        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        if (k > n) return head;
        if (2 * k - 1 == n) return head;
        Node prevX = null, currX = head;
        for (int i = 1; i < k; i++) {
            prevX = currX;
            currX = currX.next;
        }
        Node prevY = null, currY = head;
        for (int i = 1; i < n - k + 1; i++) {
            prevY = currY;
            currY = currY.next;
        }
        if (prevX != null) prevX.next = currY;
        if (prevY != null) prevY.next = currX;
        Node tempNext = currX.next;
        currX.next = currY.next;
        currY.next = tempNext;
        if (k == 1) head = currY;
        if (k == n) head = currX;
        return head;
    }
}