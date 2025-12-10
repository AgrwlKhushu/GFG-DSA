class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        
        int n = arr.length;
        int[] freq = new int[n + 1];
        int repeating = -1, missing = -1;
        
        for (int x : arr) {
            freq[x]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) repeating = i;
            else if (freq[i] == 0) missing = i;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repeating);
        ans.add(missing);
        return ans;
    }
}
