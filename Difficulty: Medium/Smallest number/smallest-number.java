//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        int t=1;
        for(int i=0;i<d-1;i++){
            t=t*10;
        }
        int h=t*10-1;
        for(int i=t;i<=h;i++){
            if(sod(i,s)){
                return Integer.toString(i);
            }
        }
        return "-1";
    }
    static boolean sod(int n,int s){
        int a=n;
        int r=0;
        int sum=0;
        while(a>0){
            r=a%10;
            sum=sum+r;
            a=a/10;
            
        }
        if(sum==s){
            return true;
        }
        else{
            return false;
        }    
    }
}
