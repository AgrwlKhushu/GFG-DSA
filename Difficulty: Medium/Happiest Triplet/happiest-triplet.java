class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        // write code here
        
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        int[] ans = new int[3];
        
        for(int i = 0; i < a.length; i++) {
            int l = 0, r = b.length - 1;
            while(l <= r) {
                int j = l + (r - l) / 2;
                int x = a[i], y = b[j];
                int target = (x + y) / 2;
                
                int left = 0, right = c.length - 1;
                while(left <= right) {
                    int mid = left + (right - left) / 2;
                    int z = c[mid];
                    int mx = Math.max(x, Math.max(y, z));
                    int mn = Math.min(x, Math.min(y, z));
                    int diff = mx - mn;
                    int sum = x + y + z;
                    
                    if(diff < minDiff || (diff == minDiff && sum < minSum)) {
                        minDiff = diff;
                        minSum = sum;
                        int[] temp = {x, y, z};
                        Arrays.sort(temp);
                        ans[0] = temp[2];
                        ans[1] = temp[1];
                        ans[2] = temp[0];
                    }
                    
                    if(c[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                
                if(b[j] < a[i]) {
                    l = j + 1;
                } else {
                    r = j - 1;
                }
            }
        }
        return ans;
    }
}
