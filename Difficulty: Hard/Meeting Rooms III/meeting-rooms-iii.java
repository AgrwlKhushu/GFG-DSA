//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int[] count = new int[n];

        // Min-heap for available rooms by room number
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        // Min-heap for occupied rooms by [endTime, room]
        PriorityQueue<long[]> occupiedRooms = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Integer.compare((int)a[1], (int)b[1])
        );

        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            // Free up rooms
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= start) {
                availableRooms.offer((int) occupiedRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                count[room]++;
                occupiedRooms.offer(new long[]{start + duration, room});
            } else {
                // Delay meeting
                long[] earliest = occupiedRooms.poll();
                long newStart = earliest[0];
                long newEnd = newStart + duration;
                int room = (int) earliest[1];
                count[room]++;
                occupiedRooms.offer(new long[]{newEnd, room});
            }
        }

        // Now find the room with the most meetings
        int resultRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[resultRoom] || (count[i] == count[resultRoom] && i < resultRoom)) {
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends