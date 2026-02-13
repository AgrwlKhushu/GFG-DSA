class Solution {
    int getCount(int n, int d) {
        if (d > n) return 0;
        int s = 1, e = n, ans = n + 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (ok(mid, d)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        if (ans == n + 1) return 0;
        return n - ans + 1;
    }
    
    boolean ok(int val, int d) {
        int sum = 0, x = val;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return val - sum >= d;
    }
}
