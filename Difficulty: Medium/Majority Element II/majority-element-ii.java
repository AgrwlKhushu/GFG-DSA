//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);

            if (ans.size() == 0) {
                System.out.println("[]");
            } else {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        int votes1=0,candidate1=-1;
        int votes2=0,candidate2=-1;
        int n=nums.length;
        
        for(int i=0;i<n;i++)
        {
            if(candidate1==nums[i])
                votes1++;
            else if(candidate2==nums[i])
                votes2++;
            else if(votes1==0)
            {
                candidate1=nums[i];
                votes1=1;
            }
            else if(votes2==0)
            {
                candidate2=nums[i];
                votes2=1;
            }
            else
            {
                votes1--;
                votes2--;
            }
        }
        
        int count1=0,count2=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==candidate1)
                count1++;
            else if(nums[i]==candidate2)
                count2++;
        }
        
        ArrayList<Integer> res= new ArrayList<Integer>();
        
        if (count1 > n / 3) res.add(candidate1);
        if (count2 > n / 3) res.add(candidate2);
        if (res.size() == 2 && res.get(0) > res.get(1)) 
            Collections.swap(res, 0, 1);
        return res;
    }
}
