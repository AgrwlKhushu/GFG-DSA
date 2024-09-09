//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int zero=0;
        int one=0;
        int two=0;
        for(int num : arr)
        {
            if(num==0)
            {
                zero++;
            }
            if(num==1)
            {
                one++;
            }
            if(num==2)
            {
                two++;
            }
        }
        int i;
        for(i=0;i<zero;i++)
        {
            arr.set(i,0);
        }
        for(;i<one+zero;i++)
        {
            arr.set(i,1);
        }
        for(;i<one+zero+two;i++)
        {
            arr.set(i,2);
        }
    }
}