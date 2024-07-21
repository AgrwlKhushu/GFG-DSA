//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        int n = arr.size();
        if (n == 1) {
            return arr.get(0);
        }

        long ans = 1;
        int mod = 1000000007;
        int id = -1;
        int minElement = 0;
        int zeroCount = 0;
        int negCount = 0;

        for (int i = 0; i < n; i++) {
            int num = arr.get(i);
            if (num == 0) {
                zeroCount++;
            } else if (num < 0) {
                negCount++;
                if (id == -1 || num > minElement) {
                    id = i;
                    minElement = num;
                }
            }
        }

        if (zeroCount == n) {
            return 0;
        }

        if (negCount == 1 && zeroCount == n - 1) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            int num = arr.get(i);
            if (num == 0) {
                continue;
            }
            if (negCount % 2 == 1 && i == id) {
                continue;
            }
            ans = ((ans * num) % mod + mod) % mod;
        }

        return ans;
    }
}