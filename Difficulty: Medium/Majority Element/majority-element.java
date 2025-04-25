//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // code here
        if(arr.length==1)
            return arr[0];
        Arrays.sort(arr);
        int l=1,pl=1;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]==arr[i+1])
            l++;
            if(l>pl)
                pl=l;
            if(arr[i]!=arr[i+1])
            {
                if(l>((arr.length)/2))
                return arr[i];
                l=1;
            }
        }
        if(pl>((arr.length)/2))
        return arr[arr.length-1];
        else 
        return -1;
    }
}