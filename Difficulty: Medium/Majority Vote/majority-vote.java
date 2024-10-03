//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        
        List<Integer> ans = new ArrayList<>();
        int c1 =0;
        int c2=0;
        int n = nums.size();
        int num1 = -1;
        int num2= -1;
        for(int i=0;i<n;i++){
            int num = nums.get(i);
             if (num == num1) {
                c1++;
            } else if (num == num2) {
                c2++;
            } else if (c1 == 0) {
                num1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                num2 = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        
        for(int i=0;i<n;i++){
            int num = nums.get(i);
            if(num==num1){
                c1++;
            }
            else if(num==num2){
                c2++;
            }
        }
        if(c1 > n/3){
            ans.add(num1);
        }
        if(c2 > n/3 && num1!=num2){
            ans.add(num2);
        }
        if (ans.isEmpty()) {
            ans.add(-1);
        }
        return ans;
    }
}
