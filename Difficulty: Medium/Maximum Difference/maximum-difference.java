//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        Stack<Integer>leftstack=new Stack<>();
        Stack<Integer>rightstack=new Stack<>();
        int left[]=new int[arr.length];
        int right[]=new int[arr.length];
        
        
        for(int i=0;i<arr.length;i++){
            while(!leftstack.isEmpty() && leftstack.peek()>=arr[i]){
                leftstack.pop();
            }
            if(leftstack.isEmpty()){
                left[i]=0;
            }
            if(leftstack.isEmpty()==false){
                left[i]=leftstack.peek();
            }
            leftstack.push(arr[i]);
            
        }
        for(int i=arr.length-1;i>=0;i--){
            while(rightstack.isEmpty()==false && rightstack.peek()>=arr[i]){
                rightstack.pop();
            }
            if(rightstack.isEmpty()){
                right[i]=0;
            }
            if(rightstack.isEmpty()==false){
                right[i]=rightstack.peek();
            }
            rightstack.push(arr[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,Math.abs(left[i]-right[i]));
        }
        return max;
    }
}
