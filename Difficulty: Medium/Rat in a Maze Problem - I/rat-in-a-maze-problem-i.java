//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] m) {
        // Your code here
        int n=m.length;
         ArrayList<String> ans= new ArrayList<>();
        int[][] visited= new int[n][n];
        rec(m,n,0,0,ans,"",visited);
        if(ans.isEmpty()){
            ans.add("-1");
        }
        return ans;
    }
    private static void rec(int[][] m,int n, int x, int y, ArrayList<String> ans,String str,int[][] visited){
      
        if(x>=n|| y>=n||x<0||y<0){
            return ;
        }
        if(m[x][y]==0||visited[x][y]==1){
            return;
        }
         if(x==n-1 && y==n-1 && m[x][y]==1){
            ans.add(str);
            return;
        }
        visited[x][y]=1;
        rec(m,n,x-1,y,ans,str+"U",visited);
        rec(m,n,x+1,y,ans,str+"D",visited);
        rec(m,n,x,y-1,ans,str+"L",visited);
        rec(m,n,x,y+1,ans,str+"R",visited);
        visited[x][y]=0;
        return;
    }
}