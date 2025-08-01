//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        
        ArrayList<Integer> list = new ArrayList<>();
        
        HashMap<Integer , Integer> map = new HashMap<>();
        
        int i = 0;
        while(i < k){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
            i++;
        }
        
        list.add(map.size());
        int idx = 0;
        
        while(i < arr.length){
            
            if(map.get(arr[idx]) == 1) map.remove(arr[idx]);
            else map.put(arr[idx] , map.get(arr[idx])-1);
            
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
            list.add(map.size());
            
            i++;  idx++;
        }
        
        return list;
    }
}