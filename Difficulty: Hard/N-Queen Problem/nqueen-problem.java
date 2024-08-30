//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
         ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        solve(0, new int[n], results);
        return results;
    }

    private void solve(int row, int[] columns, ArrayList<ArrayList<Integer>> results) {
        int n = columns.length;
        if (row == n) {
            addSolution(columns, results);
        } else {
            for (int i = 0; i < n; i++) {
                if (canPlaceQueen(columns, row, i)) {
                    columns[row] = i;
                    solve(row + 1, columns, results);
                }
            }
        }
    }

    private boolean canPlaceQueen(int[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];
            if (column1 == column2) {
                return false;
            }
            int columnDistance = Math.abs(column2 - column1);
            int rowDistance = row1 - row2;
            if (columnDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }

    private void addSolution(int[] columns, ArrayList<ArrayList<Integer>> results) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < columns.length; i++) {
            solution.add(columns[i] + 1);
        }
        results.add(solution);
    }
}