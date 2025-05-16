//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Element implements Comparable<Element> {
        int value, row, index;

        public Element(int value, int row, int index) {
            this.value = value;
            this.row = row;
            this.index = index;
        }

        public int compareTo(Element other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;

        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        // Initialize heap with the first element of each list
        for (int i = 0; i < k; i++) {
            int val = arr[i][0];
            minHeap.offer(new Element(val, i, 0));
            max = Math.max(max, val);
        }

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        while (true) {
            Element curr = minHeap.poll();
            int min = curr.value;

            // Update result range if smaller
            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            // If we reached the end of one list, stop
            if (curr.index == n - 1) {
                break;
            }

            // Add next element of the same list
            int nextVal = arr[curr.row][curr.index + 1];
            minHeap.offer(new Element(nextVal, curr.row, curr.index + 1));
            max = Math.max(max, nextVal);
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(rangeStart);
        result.add(rangeEnd);
        return result;
    }
}