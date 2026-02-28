class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        // code here
        
        int n = arr1.length;
        int m = arr2.length;
        int l = 0, r = m - 1;
        int diff = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        
        while (l < n && r >= 0) {
            int sum = arr1[l] + arr2[r];
            int currDiff = Math.abs(sum - x);
            
            if (currDiff < diff) {
                diff = currDiff;
                result.clear();
                result.add(arr1[l]);
                result.add(arr2[r]);
            }
            
            if (sum > x) {
                r--;
            } else {
                l++;
            }
        }
        
        return result;
        
    }
}