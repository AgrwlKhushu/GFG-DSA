//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        Map<Integer,Integer> s = new HashMap<Integer,Integer>();
        int result =0;
        s.put(result,1);
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            result=result^arr[i];
            int curr_xor=result^k;
            if(s.containsKey(curr_xor)){
                cnt+=s.get(curr_xor);
            }
            if(s.containsKey(result)){
                s.put(result,s.get(result)+1);
            }
            else{
                s.put(result,1);
            }
        }
        return cnt;
    }
}